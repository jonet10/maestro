import React, { useState } from 'react';
import { Send, Users, Mail, AlertCircle, CheckCircle2 } from 'lucide-react';
import { supabase } from '../utils/supabaseClient';
import { COUNTRIES } from '../utils/countryData';
import { supportedLanguages } from '../i18n/LanguageContext';

export const EmailingAdminTab: React.FC = () => {
  const [subject, setSubject] = useState('');
  const [htmlContent, setHtmlContent] = useState('<h1>Bonjour !</h1><p>Voici un message de Maestro Domino.</p>');
  const [recipientOption, setRecipientOption] = useState<'all' | 'active'>('active');
  const [filterCountry, setFilterCountry] = useState('all');
  const [filterLanguage, setFilterLanguage] = useState('all');
  const [filterTimezone, setFilterTimezone] = useState('all');
  
  const [isSending, setIsSending] = useState(false);
  const [feedback, setFeedback] = useState<{ type: 'success' | 'error', message: string } | null>(null);

  const handleSendCampaign = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!subject.trim() || !htmlContent.trim()) {
      setFeedback({ type: 'error', message: "Le sujet et le contenu sont obligatoires." });
      return;
    }

    if (!window.confirm(`Êtes-vous sûr de vouloir envoyer cet email à l'audience sélectionnée (${recipientOption}) ?`)) {
      return;
    }

    setIsSending(true);
    setFeedback(null);

    try {
      // Call the Supabase Edge Function to handle the actual sending with target filters
      const { data, error } = await supabase.functions.invoke('send-emails', {
        body: {
          subject,
          htmlContent,
          targetAudience: recipientOption,
          filters: {
            country: filterCountry !== 'all' ? filterCountry : null,
            language: filterLanguage !== 'all' ? filterLanguage : null,
            timezone: filterTimezone !== 'all' ? filterTimezone : null
          }
        }
      });

      if (error) throw error;

      setFeedback({ 
        type: 'success', 
        message: `Campagne envoyée avec succès à ${data?.sentCount || 0} utilisateurs !` 
      });
      setSubject('');
    } catch (err: any) {
      console.error("Emailing error:", err);
      setFeedback({ type: 'error', message: err.message || "Erreur lors de l'envoi de la campagne." });
    } finally {
      setIsSending(false);
    }
  };

  return (
    <div className="flex flex-col gap-6 p-4">
      <div className="bg-[#121212] border border-stone-800 rounded-2xl p-6 shadow-xl">
        <h2 className="text-xl font-bold text-amber-500 font-serif mb-2 flex items-center gap-2">
          <Mail size={24} />
          Campagne d'Emailing & Ciblage
        </h2>
        <p className="text-sm text-stone-400 mb-6">
          Utilisez ce formulaire pour envoyer un email de masse ciblé aux joueurs inscrits. Les emails sont expédiés via notre fonction Edge Supabase.
        </p>

        {feedback && (
          <div className={`p-4 rounded-xl mb-6 flex items-start gap-3 border ${
            feedback.type === 'success' ? 'bg-emerald-950/30 border-emerald-500/30 text-emerald-400' : 'bg-red-950/30 border-red-500/30 text-red-400'
          }`}>
            {feedback.type === 'success' ? <CheckCircle2 className="shrink-0 mt-0.5" size={18} /> : <AlertCircle className="shrink-0 mt-0.5" size={18} />}
            <span className="text-sm">{feedback.message}</span>
          </div>
        )}

        <form onSubmit={handleSendCampaign} className="flex flex-col gap-5 text-left">
          
          <div className="flex flex-col gap-2">
            <label className="text-xs font-bold text-stone-500 uppercase tracking-wider">Ciblage de Base</label>
            <div className="flex gap-4">
              <label className="flex items-center gap-2 text-sm text-stone-300 cursor-pointer p-3 border border-stone-800 rounded-lg hover:border-amber-500/30 transition-colors">
                <input 
                  type="radio" 
                  name="recipient" 
                  value="all" 
                  checked={recipientOption === 'all'} 
                  onChange={() => setRecipientOption('all')}
                  className="accent-amber-500"
                />
                <Users size={16} className="text-stone-500" />
                Tous les joueurs
              </label>
              <label className="flex items-center gap-2 text-sm text-stone-300 cursor-pointer p-3 border border-stone-800 rounded-lg hover:border-amber-500/30 transition-colors">
                <input 
                  type="radio" 
                  name="recipient" 
                  value="active" 
                  checked={recipientOption === 'active'} 
                  onChange={() => setRecipientOption('active')}
                  className="accent-amber-500"
                />
                <Users size={16} className="text-amber-500" />
                Joueurs Actifs (Saison en cours)
              </label>
            </div>
          </div>

          {/* Filtering Section */}
          <div className="bg-stone-900/40 border border-stone-850 p-4 rounded-xl space-y-4">
            <label className="text-xs font-bold text-amber-500 uppercase tracking-wider block">Filtres de Géolocalisation & Langue</label>
            <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
              <div className="flex flex-col gap-1.5">
                <span className="text-[10px] text-stone-500 uppercase font-mono font-bold tracking-wider">Filtrer par Pays</span>
                <select
                  value={filterCountry}
                  onChange={(e) => setFilterCountry(e.target.value)}
                  className="bg-black/50 border border-stone-800 rounded-xl px-3 py-2 text-xs text-stone-200 outline-none focus:border-amber-500 font-mono"
                >
                  <option value="all">Tous les Pays</option>
                  {COUNTRIES.map(c => (
                    <option key={c.code} value={c.code}>{c.flag} {c.name}</option>
                  ))}
                </select>
              </div>

              <div className="flex flex-col gap-1.5">
                <span className="text-[10px] text-stone-500 uppercase font-mono font-bold tracking-wider">Filtrer par Langue</span>
                <select
                  value={filterLanguage}
                  onChange={(e) => setFilterLanguage(e.target.value)}
                  className="bg-black/50 border border-stone-800 rounded-xl px-3 py-2 text-xs text-stone-200 outline-none focus:border-amber-500 font-mono"
                >
                  <option value="all">Toutes les Langues</option>
                  {supportedLanguages.map(l => (
                    <option key={l.code} value={l.code}>{l.flag} {l.name}</option>
                  ))}
                </select>
              </div>

              <div className="flex flex-col gap-1.5">
                <span className="text-[10px] text-stone-500 uppercase font-mono font-bold tracking-wider">Fuseau Horaire</span>
                <select
                  value={filterTimezone}
                  onChange={(e) => setFilterTimezone(e.target.value)}
                  className="bg-black/50 border border-stone-800 rounded-xl px-3 py-2 text-xs text-stone-200 outline-none focus:border-amber-500 font-mono"
                >
                  <option value="all">Tous les Fuseaux Horaires</option>
                  <option value="America/Port-au-Prince">America/Port-au-Prince (Haïti)</option>
                  <option value="Europe/Paris">Europe/Paris (France)</option>
                  <option value="America/New_York">America/New_York (États-Unis)</option>
                  <option value="America/Toronto">America/Toronto (Canada)</option>
                  <option value="America/Santo_Domingo">America/Santo_Domingo (Dom. Rep.)</option>
                  <option value="America/Sao_Paulo">America/Sao_Paulo (Brésil)</option>
                </select>
              </div>
            </div>
          </div>

          <div className="flex flex-col gap-2">
            <label className="text-xs font-bold text-stone-500 uppercase tracking-wider">Sujet de l'email</label>
            <input
              type="text"
              value={subject}
              onChange={(e) => setSubject(e.target.value)}
              placeholder="Ex: Le Tournoi de Printemps commence demain !"
              className="bg-black/50 border border-stone-800 rounded-xl px-4 py-3 text-sm text-stone-200 focus:border-amber-500 outline-none transition-colors"
              required
            />
          </div>

          <div className="flex flex-col gap-2">
            <label className="text-xs font-bold text-stone-500 uppercase tracking-wider">Contenu (HTML)</label>
            <textarea
              value={htmlContent}
              onChange={(e) => setHtmlContent(e.target.value)}
              rows={8}
              className="bg-black/50 border border-stone-800 rounded-xl px-4 py-3 text-sm text-stone-200 font-mono focus:border-amber-500 outline-none transition-colors custom-scrollbar"
              required
            />
            <p className="text-[10px] text-stone-500">Vous pouvez utiliser des balises HTML standards pour la mise en forme.</p>
          </div>

          <button
            type="submit"
            disabled={isSending}
            className="mt-4 bg-amber-600 hover:bg-amber-500 disabled:bg-stone-800 disabled:text-stone-600 text-stone-950 font-bold py-3 px-6 rounded-xl transition-colors flex items-center justify-center gap-2 self-start cursor-pointer font-sans"
          >
            {isSending ? (
              <span className="animate-pulse">Envoi en cours...</span>
            ) : (
              <>
                <Send size={18} />
                Lancer la Campagne Ciblée
              </>
            )}
          </button>
        </form>
      </div>
    </div>
  );
};
