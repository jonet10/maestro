import React, { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { supabase } from '../utils/supabaseClient';
import { Profile } from '../types';
import { COUNTRIES } from '../utils/countryData';
import { supportedLanguages, Language, useTranslation } from '../i18n/LanguageContext';

interface OnboardingWizardProps {
  profile: Profile;
  onComplete: (updatedProfile: Profile) => void;
}

const HOURS_24 = [
  "06:00", "07:00", "08:00", "09:00",
  "10:00", "11:00", "12:00", "13:00",
  "14:00", "15:00", "16:00", "17:00",
  "18:00", "19:00", "20:00", "21:00",
  "22:00", "23:00", "00:00", "01:00",
  "02:00", "03:00", "04:00", "05:00"
];

export const OnboardingWizard: React.FC<OnboardingWizardProps> = ({ profile, onComplete }) => {
  const [step, setStep] = useState(1);
  const [countryCode, setCountryCode] = useState(profile.country_code || "");
  const { setLanguage } = useTranslation();
  const [preferredLanguage, setPreferredLanguage] = useState<Language>((profile.preferred_language as Language) || "fr");
  const [timezone, setTimezone] = useState(profile.timezone || "");
  const [acceptGameInvites, setAcceptGameInvites] = useState(profile.accept_game_invites !== false);
  const [selectedHours, setSelectedHours] = useState<string[]>([]);
  const [isSaving, setIsSaving] = useState(false);

  const toggleHour = (hour: string) => {
    setSelectedHours(prev => 
      prev.includes(hour) ? prev.filter(h => h !== hour) : [...prev, hour]
    );
  };


  const handleSave = async () => {
    if (!countryCode) {
      alert("Veuillez sélectionner un pays.");
      return;
    }
    setIsSaving(true);
    try {
      const finalTimezone = timezone || Intl.DateTimeFormat().resolvedOptions().timeZone;
      const availability = {
        timezone: finalTimezone,
        hours: selectedHours
      };

      // 1. Update Profile in DB
      const { data, error } = await supabase
        .from('profiles')
        .update({ 
          country_code: countryCode,
          preferred_language: preferredLanguage,
          timezone: finalTimezone,
          accept_game_invites: acceptGameInvites,
          onboarding_completed: true,
          availability 
        })
        .eq('id', profile.id)
        .select()
        .single();

      if (error) throw error;

      // 2. Insert availability slots to database table user_availabilities for all 7 days of the week
      const availabilitiesToInsert = [0, 1, 2, 3, 4, 5, 6].flatMap(dayNum => {
        return selectedHours.map(hour => {
          const startH = hour.split(":")[0];
          const endH = String((Number(startH) + 1) % 24).padStart(2, "0");
          return {
            user_id: profile.id,
            day_of_week: dayNum,
            start_time: `${startH}:00:00`,
            end_time: `${endH}:00:00`,
            timezone: finalTimezone,
            type: 'regular'
          };
        });
      });

      if (availabilitiesToInsert.length > 0) {
        // Delete previous regular availabilities if any (overwrite)
        await supabase
          .from("user_availabilities")
          .delete()
          .eq("user_id", profile.id)
          .eq("type", "regular");

        const { error: availError } = await supabase
          .from("user_availabilities")
          .insert(availabilitiesToInsert);
        
        if (availError) {
          console.error("Error inserting availabilities to database:", availError);
        }
      }
      
      if (data) {
        onComplete(data as Profile);
      }
    } catch (err: any) {
      console.error("Error saving onboarding data:", err);
      alert("Erreur d'enregistrement : " + (err.message || "") + "\n\n⚠️ Veuillez vous assurer d'avoir exécuté la migration '022_internationalization.sql' dans l'éditeur SQL de votre Dashboard Supabase pour ajouter les nouvelles colonnes (country_code, preferred_language, timezone, etc.) à la table des profils.");
      setIsSaving(false);
      // Fallback to unblock the user locally in case of RLS or network issue
      onComplete({ 
        ...profile, 
        country_code: countryCode,
        preferred_language: preferredLanguage,
        timezone: timezone || Intl.DateTimeFormat().resolvedOptions().timeZone,
        accept_game_invites: acceptGameInvites,
        onboarding_completed: true, 
        availability: {
          timezone: timezone || Intl.DateTimeFormat().resolvedOptions().timeZone,
          hours: selectedHours
        }
      });
    }
  };

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center p-4 bg-black/85 backdrop-blur-md">
      <AnimatePresence mode="wait">
        {step === 1 && (
          <motion.div
            key="step1"
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, x: -50 }}
            className="bg-[#0c0c0c] border border-gray-800 p-8 rounded-2xl shadow-2xl max-w-md w-full text-center relative overflow-hidden"
          >
            <span className="text-4xl block mb-4">🎉</span>
            <h2 className="text-2xl font-bold text-amber-500 mb-4 font-serif">Complétez votre profil !</h2>
            <p className="text-gray-300 text-sm leading-relaxed mb-8">
              Maestro Domino évolue et propose de nouvelles fonctionnalités internationales. <br/><br/>
              Veuillez renseigner votre pays, votre langue et vos disponibilités pour continuer à jouer et trouver vos amis.
            </p>
            
            <div className="flex flex-col gap-3">
              <button
                onClick={() => setStep(2)}
                className="bg-amber-600 hover:bg-amber-500 text-stone-950 font-bold py-3 px-6 rounded-lg transition-colors cursor-pointer"
              >
                Commencer
              </button>
            </div>
          </motion.div>
        )}

        {step === 2 && (
          <motion.div
            key="step2"
            initial={{ opacity: 0, x: 50 }}
            animate={{ opacity: 1, x: 0 }}
            exit={{ opacity: 0, x: -50 }}
            className="bg-[#0c0c0c] border border-gray-800 p-6 rounded-2xl shadow-2xl max-w-md w-full relative overflow-hidden"
          >
            <h3 className="text-xl font-bold text-amber-500 mb-1 font-serif text-center">Votre Région & Langue</h3>
            <p className="text-gray-400 text-xs text-center mb-6">Sélectionnez vos préférences régionales.</p>
            
            <div className="space-y-4 mb-6">
              <div className="space-y-1">
                <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Choix du Pays</label>
                <select
                  value={countryCode}
                  onChange={(e) => {
                    const code = e.target.value;
                    setCountryCode(code);
                    const found = COUNTRIES.find(c => c.code === code);
                    if (found) {
                      setPreferredLanguage(found.defaultLang as any);
                      setTimezone(found.defaultTimezone);
                      setLanguage(found.defaultLang as any);
                    }
                  }}
                  className="w-full bg-[#121212] border border-gray-805 rounded-xl py-2 px-3 text-xs text-white focus:outline-none focus:border-amber-500/60 transition-all font-mono"
                >
                  <option value="">Sélectionner votre pays...</option>
                  {COUNTRIES.map((c) => (
                    <option key={c.code} value={c.code}>
                      {c.flag} {c.name} ({c.code})
                    </option>
                  ))}
                </select>
              </div>

              <div className="space-y-1">
                <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Langue préférée</label>
                <select
                  value={preferredLanguage}
                  onChange={(e) => setPreferredLanguage(e.target.value as any)}
                  className="w-full bg-[#121212] border border-gray-805 rounded-xl py-2 px-3 text-xs text-white focus:outline-none focus:border-amber-500/60 transition-all font-mono"
                >
                  {supportedLanguages.map((l) => (
                    <option key={l.code} value={l.code}>{l.flag} {l.name}</option>
                  ))}
                </select>
              </div>

              <div className="space-y-1">
                <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Fuseau horaire (IANA)</label>
                <input
                  type="text"
                  required
                  value={timezone}
                  onChange={(e) => setTimezone(e.target.value)}
                  placeholder="ex: America/Port-au-Prince"
                  className="w-full bg-[#121212] border border-gray-805 rounded-xl py-2 px-3 text-xs text-white focus:outline-none focus:border-amber-500/60 transition-all font-mono"
                />
              </div>

              <div className="flex items-center justify-between p-2.5 bg-[#121212] border border-gray-850 rounded-xl">
                <div className="space-y-0.5">
                  <span className="text-xs font-bold text-white">Accepter les invitations</span>
                  <p className="text-[9px] text-gray-500">Permet aux autres de vous inviter.</p>
                </div>
                <input
                  type="checkbox"
                  checked={acceptGameInvites}
                  onChange={(e) => setAcceptGameInvites(e.target.checked)}
                  className="h-4 w-4 accent-amber-500 rounded cursor-pointer"
                />
              </div>
            </div>
            
            <div className="flex justify-between items-center pt-2">
              <button
                onClick={() => setStep(1)}
                className="text-gray-400 hover:text-white text-sm"
              >
                Retour
              </button>
              <button
                onClick={() => {
                  if (!countryCode) {
                    alert("Veuillez sélectionner un pays.");
                    return;
                  }
                  setStep(3);
                }}
                className="bg-amber-600 hover:bg-amber-500 text-stone-950 font-bold py-2 px-6 rounded-lg transition-colors cursor-pointer"
              >
                Continuer
              </button>
            </div>
          </motion.div>
        )}

        {step === 3 && (
          <motion.div
            key="step3"
            initial={{ opacity: 0, x: 50 }}
            animate={{ opacity: 1, x: 0 }}
            exit={{ opacity: 0, y: -20 }}
            className="bg-[#0c0c0c] border border-gray-800 p-6 rounded-2xl shadow-2xl max-w-md w-full relative overflow-hidden"
          >
            <h3 className="text-xl font-bold text-amber-500 mb-1 font-serif text-center font-display">Vos disponibilités</h3>
            <p className="text-gray-400 text-xs text-center mb-6">Sélectionnez vos heures de jeu habituelles.</p>
            
            <div className="mb-6 max-h-60 overflow-y-auto no-scrollbar">
              <div className="grid grid-cols-4 gap-2 pt-1">
                {HOURS_24.map(hour => {
                  const isSelected = selectedHours.includes(hour);
                  return (
                    <button
                      key={hour}
                      onClick={() => toggleHour(hour)}
                      className={`py-3 rounded-md text-xs font-bold transition-colors border text-center cursor-pointer ${
                        isSelected 
                          ? 'bg-amber-600 border-amber-500 text-stone-950' 
                          : 'bg-[#121212] border-stone-700 text-gray-300 hover:border-amber-900'
                      }`}
                    >
                      {hour}
                    </button>
                  );
                })}
              </div>
            </div>
            
            <div className="flex justify-between items-center">
              <button
                onClick={() => setStep(2)}
                className="text-gray-400 hover:text-white text-sm"
              >
                Retour
              </button>
              <button
                onClick={handleSave}
                disabled={isSaving}
                className="bg-amber-600 hover:bg-amber-500 text-stone-950 font-bold py-2 px-6 rounded-lg transition-colors flex items-center gap-2 cursor-pointer"
              >
                {isSaving ? 'Enregistrement...' : 'Terminer'}
              </button>
            </div>
          </motion.div>
        )}
      </AnimatePresence>
    </div>
  );
};
