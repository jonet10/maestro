import React, { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { supabase } from '../utils/supabaseClient';
import { Profile } from '../types';

interface OnboardingWizardProps {
  profile: Profile;
  onComplete: (updatedProfile: Profile) => void;
}

const DAYS_OF_WEEK = [
  { id: 'monday', label: 'Lundi' },
  { id: 'tuesday', label: 'Mardi' },
  { id: 'wednesday', label: 'Mercredi' },
  { id: 'thursday', label: 'Jeudi' },
  { id: 'friday', label: 'Vendredi' },
  { id: 'saturday', label: 'Samedi' },
  { id: 'sunday', label: 'Dimanche' },
];

const TIME_SLOTS = [
  { id: '06-09', label: '06h - 09h' },
  { id: '09-12', label: '09h - 12h' },
  { id: '12-15', label: '12h - 15h' },
  { id: '15-18', label: '15h - 18h' },
  { id: '18-21', label: '18h - 21h' },
  { id: '21-00', label: '21h - 00h' },
];

export const OnboardingWizard: React.FC<OnboardingWizardProps> = ({ profile, onComplete }) => {
  const [step, setStep] = useState(1);
  const [selectedDays, setSelectedDays] = useState<string[]>([]);
  const [selectedTimeSlots, setSelectedTimeSlots] = useState<string[]>([]);
  const [isSaving, setIsSaving] = useState(false);

  const toggleDay = (dayId: string) => {
    setSelectedDays(prev => 
      prev.includes(dayId) ? prev.filter(d => d !== dayId) : [...prev, dayId]
    );
  };

  const toggleTimeSlot = (slotId: string) => {
    setSelectedTimeSlots(prev => 
      prev.includes(slotId) ? prev.filter(s => s !== slotId) : [...prev, slotId]
    );
  };

  const handleSave = async () => {
    setIsSaving(true);
    try {
      const timezone = Intl.DateTimeFormat().resolvedOptions().timeZone;
      const availability = {
        timezone,
        days: selectedDays,
        timeSlots: selectedTimeSlots
      };

      const { data, error } = await supabase
        .from('profiles')
        .update({ 
          onboarding_completed: true,
          availability 
        })
        .eq('id', profile.id)
        .select()
        .single();

      if (error) throw error;
      
      if (data) {
        onComplete(data as Profile);
      }
    } catch (err) {
      console.error("Error saving onboarding data:", err);
      // Even if there's an error, we can let them play, but ideally we'd show a toast
      setIsSaving(false);
      // Fallback to unblock the user locally in case of RLS or network issue
      onComplete({ 
        ...profile, 
        onboarding_completed: true, 
        availability: {
          timezone: Intl.DateTimeFormat().resolvedOptions().timeZone,
          days: selectedDays,
          timeSlots: selectedTimeSlots
        }
      });
    }
  };

  const skip = async () => {
    setIsSaving(true);
    try {
      const { data, error } = await supabase
        .from('profiles')
        .update({ onboarding_completed: true })
        .eq('id', profile.id)
        .select()
        .single();

      if (error) throw error;
      if (data) {
        onComplete(data as Profile);
      }
    } catch (err) {
      console.error("Error skipping onboarding:", err);
      setIsSaving(false);
      onComplete({ ...profile, onboarding_completed: true });
    }
  };

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center p-4 bg-black/80 backdrop-blur-sm">
      <AnimatePresence mode="wait">
        {step === 1 && (
          <motion.div
            key="step1"
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, x: -50 }}
            className="bg-stone-900 border border-amber-900/50 p-8 rounded-2xl shadow-2xl max-w-md w-full text-center relative overflow-hidden"
          >
            <div className="absolute inset-0 bg-[url('https://www.transparenttextures.com/patterns/wood-pattern.png')] opacity-5 mix-blend-overlay pointer-events-none"></div>
            
            <span className="text-4xl block mb-4">🎉</span>
            <h2 className="text-2xl font-bold text-amber-500 mb-4 font-serif">Bienvenue sur la nouvelle version !</h2>
            <p className="text-stone-300 text-sm leading-relaxed mb-8">
              Maestro Domino évolue et devient une véritable plateforme sociale. <br/><br/>
              Pour vous aider à trouver des adversaires et participer aux futurs tournois, nous aimerions connaître vos habitudes de jeu.
            </p>
            
            <div className="flex flex-col gap-3">
              <button
                onClick={() => setStep(2)}
                className="bg-amber-600 hover:bg-amber-500 text-stone-950 font-bold py-3 px-6 rounded-lg transition-colors"
              >
                Compléter mon profil
              </button>
              <button
                onClick={skip}
                disabled={isSaving}
                className="text-stone-500 hover:text-stone-300 text-sm underline transition-colors"
              >
                Plus tard
              </button>
            </div>
          </motion.div>
        )}

        {step === 2 && (
          <motion.div
            key="step2"
            initial={{ opacity: 0, x: 50 }}
            animate={{ opacity: 1, x: 0 }}
            exit={{ opacity: 0, y: -20 }}
            className="bg-stone-900 border border-amber-900/50 p-6 rounded-2xl shadow-2xl max-w-md w-full relative overflow-hidden"
          >
            <h3 className="text-xl font-bold text-amber-500 mb-1 font-serif text-center">Vos disponibilités</h3>
            <p className="text-stone-400 text-xs text-center mb-6">Sélectionnez vos jours et horaires de jeu habituels (facultatif).</p>
            
            <div className="mb-6">
              <h4 className="text-stone-200 text-sm font-semibold mb-3">Jours de jeu :</h4>
              <div className="flex flex-wrap gap-2">
                {DAYS_OF_WEEK.map(day => (
                  <button
                    key={day.id}
                    onClick={() => toggleDay(day.id)}
                    className={`px-3 py-1.5 rounded-md text-xs font-medium transition-colors border ${
                      selectedDays.includes(day.id) 
                        ? 'bg-amber-600 border-amber-500 text-stone-900' 
                        : 'bg-stone-800 border-stone-700 text-stone-400 hover:border-amber-900'
                    }`}
                  >
                    {day.label}
                  </button>
                ))}
              </div>
            </div>

            <div className="mb-8">
              <h4 className="text-stone-200 text-sm font-semibold mb-3">Plages horaires :</h4>
              <div className="grid grid-cols-2 gap-2">
                {TIME_SLOTS.map(slot => (
                  <button
                    key={slot.id}
                    onClick={() => toggleTimeSlot(slot.id)}
                    className={`px-3 py-2 rounded-md text-sm transition-colors border text-center ${
                      selectedTimeSlots.includes(slot.id) 
                        ? 'bg-emerald-600/20 border-emerald-500 text-emerald-400' 
                        : 'bg-stone-800 border-stone-700 text-stone-400 hover:border-emerald-900'
                    }`}
                  >
                    {slot.label}
                  </button>
                ))}
              </div>
            </div>
            
            <div className="flex justify-between items-center">
              <button
                onClick={() => setStep(1)}
                className="text-stone-400 hover:text-white text-sm"
              >
                Retour
              </button>
              <button
                onClick={handleSave}
                disabled={isSaving}
                className="bg-amber-600 hover:bg-amber-500 text-stone-950 font-bold py-2 px-6 rounded-lg transition-colors flex items-center gap-2"
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
