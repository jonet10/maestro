import React, { useState, useEffect } from "react";
import { supabase } from "../utils/supabaseClient";
import { Mail, Lock, User, AlertCircle, Key, ChevronLeft, ArrowRight, Sparkles, Globe } from "lucide-react";
import { COUNTRIES } from "../utils/countryData";
import { supportedLanguages, Language } from "../i18n/LanguageContext";

const HOURS_24 = [
  "06:00", "07:00", "08:00", "09:00",
  "10:00", "11:00", "12:00", "13:00",
  "14:00", "15:00", "16:00", "17:00",
  "18:00", "19:00", "20:00", "21:00",
  "22:00", "23:00", "00:00", "01:00",
  "02:00", "03:00", "04:00", "05:00"
];

interface AuthPortalProps {
  onAuthSuccess: () => void;
  onBack?: () => void;
  initialView?: "login" | "register" | "forgot" | "reset-password";
}

export function AuthPortal({ onAuthSuccess, onBack, initialView = "login" }: AuthPortalProps) {
  const [view, setView] = useState<"login" | "register" | "forgot" | "reset-password">(initialView);
  const [email, setEmail] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);
  const [errorMsg, setErrorMsg] = useState<string | null>(null);
  const [successMsg, setSuccessMsg] = useState<string | null>(null);
  const [selectedHours, setSelectedHours] = useState<string[]>([]);
  const [regStep, setRegStep] = useState(1);
  const [countryCode, setCountryCode] = useState("");
  const [preferredLanguage, setPreferredLanguage] = useState<Language>("fr");
  const [timezone, setTimezone] = useState("");
  const [acceptGameInvites, setAcceptGameInvites] = useState(true);

  const toggleHour = (hour: string) => {
    setSelectedHours(prev => 
      prev.includes(hour) ? prev.filter(h => h !== hour) : [...prev, hour]
    );
  };

  useEffect(() => {
    setView(initialView);
  }, [initialView]);

  useEffect(() => {
    if (!supabase) {
      setErrorMsg("Le serveur de base de données (Supabase) n'est pas configuré. Veuillez créer un fichier .env.local contenant vos clés d'API Supabase pour activer le mode en ligne.");
    }
  }, []);

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!supabase) {
      setErrorMsg("Erreur : Le client Supabase n'est pas configuré. Vérifiez vos variables d'environnement dans .env.local.");
      return;
    }
    setLoading(true);
    setErrorMsg(null);
    setSuccessMsg(null);

    try {
      const { error } = await supabase.auth.signInWithPassword({
        email,
        password,
      });

      if (error) {
        setErrorMsg(error.message);
      } else {
        onAuthSuccess();
      }
    } catch (err: any) {
      setErrorMsg(err.message || "Une erreur est survenue lors de la connexion.");
    } finally {
      setLoading(false);
    }
  };

  const handleRegister = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!supabase) {
      setErrorMsg("Erreur : Le client Supabase n'est pas configuré. Vérifiez vos variables d'environnement dans .env.local.");
      return;
    }
    if (!username.trim() || username.length < 3) {
      setErrorMsg("Le nom d'utilisateur doit contenir au moins 3 caractères.");
      return;
    }
    if (!countryCode) {
      setErrorMsg("Veuillez sélectionner votre pays.");
      return;
    }
    if (selectedHours.length === 0) {
      setErrorMsg("Veuillez sélectionner au moins une heure de disponibilité.");
      return;
    }
    setLoading(true);
    setErrorMsg(null);
    setSuccessMsg(null);

    try {
      // Sign up the user with metadata (username, country, language, timezone, invites, and availability)
      const { data: signUpData, error } = await supabase.auth.signUp({
        email,
        password,
        options: {
          data: {
            username: username.trim(),
            country_code: countryCode,
            preferred_language: preferredLanguage,
            timezone: timezone || Intl.DateTimeFormat().resolvedOptions().timeZone,
            accept_game_invites: acceptGameInvites,
            onboarding_completed: true,
            availability: {
              timezone: timezone || Intl.DateTimeFormat().resolvedOptions().timeZone,
              hours: selectedHours
            }
          },
        },
      });

      if (error) {
        setErrorMsg(error.message);
      } else {
        const user = signUpData.user;
        if (user) {
          // Insert the availability slots into user_availabilities table for all 7 days of the week
          const availabilitiesToInsert = [0, 1, 2, 3, 4, 5, 6].flatMap(dayNum => {
            return selectedHours.map(hour => {
              const startH = hour.split(":")[0];
              const endH = String((Number(startH) + 1) % 24).padStart(2, "0");
              return {
                user_id: user.id,
                day_of_week: dayNum,
                start_time: `${startH}:00:00`,
                end_time: `${endH}:00:00`,
                timezone: timezone || Intl.DateTimeFormat().resolvedOptions().timeZone,
                type: 'regular'
              };
            });
          });
          
          if (availabilitiesToInsert.length > 0) {
            const { error: availError } = await supabase
              .from("user_availabilities")
              .insert(availabilitiesToInsert);
            if (availError) {
              console.error("Error inserting availabilities to database:", availError);
            }
          }
        }
        
        setSuccessMsg("Inscription réussie ! Un email de confirmation a été envoyé.");
        setView("login");
        setRegStep(1);
      }
    } catch (err: any) {
      setErrorMsg(err.message || "Une erreur est survenue lors de l'inscription.");
    } finally {
      setLoading(false);
    }
  };

  const handleForgotPassword = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!supabase) {
      setErrorMsg("Erreur : Le client Supabase n'est pas configuré. Vérifiez vos variables d'environnement dans .env.local.");
      return;
    }
    setLoading(true);
    setErrorMsg(null);
    setSuccessMsg(null);

    try {
      const { error } = await supabase.auth.resetPasswordForEmail(email, {
        redirectTo: window.location.origin,
      });

      if (error) {
        setErrorMsg(error.message);
      } else {
        setSuccessMsg("Un email de réinitialisation a été envoyé.");
      }
    } catch (err: any) {
      setErrorMsg(err.message || "Une erreur est survenue.");
    } finally {
      setLoading(false);
    }
  };

  const handleUpdatePassword = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!supabase) {
      setErrorMsg("Erreur : Le client Supabase n'est pas configuré. Vérifiez vos variables d'environnement dans .env.local.");
      return;
    }
    if (password.length < 6) {
      setErrorMsg("Le mot de passe doit contenir au moins 6 caractères.");
      return;
    }
    setLoading(true);
    setErrorMsg(null);
    setSuccessMsg(null);

    try {
      const { error } = await supabase.auth.updateUser({
        password: password,
      });

      if (error) {
        setErrorMsg(error.message);
      } else {
        setSuccessMsg("Mot de passe mis à jour avec succès ! Vous pouvez maintenant vous connecter.");
        setView("login");
        setPassword("");
      }
    } catch (err: any) {
      setErrorMsg(err.message || "Une erreur est survenue lors de la mise à jour du mot de passe.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="flex flex-col h-full bg-[#0a0a0a] text-gray-250 overflow-hidden font-sans relative">
      {/* Background decoration */}
      <div className="absolute top-0 left-1/2 -translate-x-1/2 w-full h-1/2 bg-amber-500/5 blur-[120px] rounded-full pointer-events-none"></div>

      {/* Header */}
      <header className="p-4 border-b border-gray-800 bg-[#0c0c0c] flex items-center justify-between z-10 shrink-0">
        {onBack ? (
          <button onClick={onBack} className="text-gray-400 hover:text-white flex items-center gap-1 cursor-pointer">
            <ChevronLeft size={20} /> Retour
          </button>
        ) : (
          <div className="w-16"></div>
        )}
        <div className="flex items-center gap-2">
          <img src="/Maesto.png" alt="Logo" className="h-6 w-auto object-contain" />
          <span className="text-xs font-bold text-amber-500 uppercase tracking-widest">Maestro Multi</span>
        </div>
        <div className="w-10"></div>
      </header>

      {/* Content Form Wrapper */}
      <div className="flex-1 flex flex-col justify-center px-8 z-10 py-6 overflow-y-auto no-scrollbar">
        <div className="w-full max-w-xs mx-auto space-y-6">
          <div className="text-center space-y-2">
            <h2 className="text-3xl font-black text-transparent bg-clip-text bg-gradient-to-r from-amber-400 to-yellow-600">
              {view === "login"
                ? "Connexion"
                : view === "register"
                ? "Créer un Compte"
                : view === "reset-password"
                ? "Nouveau Mot de Passe"
                : "Réinitialisation"}
            </h2>
            <p className="text-xs text-gray-400">
              {view === "login" 
                ? "Connectez-vous pour défier d'autres joueurs en ligne" 
                : view === "register" 
                  ? "Rejoignez le salon de jeu en ligne Maestro"
                  : view === "reset-password"
                    ? "Saisissez votre nouveau mot de passe"
                    : "Saisissez votre adresse email pour réinitialiser votre mot de passe"}
            </p>
          </div>

          {/* Feedback alerts */}
          {errorMsg && (
            <div className="p-3 bg-red-950/40 border border-red-500/30 text-red-400 text-xs rounded-xl flex items-start gap-2.5 shadow-md">
              <AlertCircle size={16} className="shrink-0 mt-0.5" />
              <span>{errorMsg}</span>
            </div>
          )}

          {successMsg && (
            <div className="p-3 bg-emerald-950/40 border border-emerald-500/30 text-emerald-400 text-xs rounded-xl flex items-start gap-2.5 shadow-md">
              <AlertCircle size={16} className="shrink-0 mt-0.5" />
              <span>{successMsg}</span>
            </div>
          )}

          {/* Form */}
          {view === "login" && (
            <form onSubmit={handleLogin} className="space-y-4">
              <div className="space-y-1">
                <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Email</label>
                <div className="relative">
                  <Mail className="absolute left-3 top-3.5 text-gray-500" size={16} />
                  <input
                    type="email"
                    required
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    placeholder="email@adresse.com"
                    className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 pl-10 pr-4 text-sm text-white placeholder-gray-600 focus:outline-none focus:border-amber-500/60 transition-all font-mono"
                  />
                </div>
              </div>

              <div className="space-y-1">
                <div className="flex justify-between items-center">
                  <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Mot de passe</label>
                  <button
                    type="button"
                    onClick={() => setView("forgot")}
                    className="text-[10px] text-amber-500 font-bold hover:underline cursor-pointer"
                  >
                    Mot de passe oublié ?
                  </button>
                </div>
                <div className="relative">
                  <Lock className="absolute left-3 top-3.5 text-gray-500" size={16} />
                  <input
                    type="password"
                    required
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    placeholder="••••••••"
                    className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 pl-10 pr-4 text-sm text-white placeholder-gray-600 focus:outline-none focus:border-amber-500/60 transition-all font-mono"
                  />
                </div>
              </div>

              <button
                type="submit"
                disabled={loading}
                className="w-full flex items-center justify-center gap-2 py-3.5 rounded-xl font-bold text-sm bg-gradient-to-b from-amber-400 to-amber-600 text-black shadow-lg shadow-amber-900/10 hover:brightness-110 active:scale-98 transition-all cursor-pointer"
              >
                <span>{loading ? "Connexion..." : "Se connecter"}</span>
                <ArrowRight size={16} />
              </button>
            </form>
          )}

          {view === "register" && (
            <form onSubmit={handleRegister} className="space-y-4">
              {/* Step indicator header */}
              <div className="flex justify-between items-center text-[10px] text-gray-500 font-mono font-bold tracking-wider uppercase border-b border-gray-900 pb-2">
                <span>{regStep === 1 ? "Étape 1: Profil" : regStep === 2 ? "Étape 2: Région & Langue" : "Étape 3: Disponibilités"}</span>
                <span>{regStep} / 3</span>
              </div>

              {/* STEP 1: Credentials */}
              {regStep === 1 && (
                <div className="space-y-4">
                  <div className="space-y-1">
                    <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Nom d'utilisateur</label>
                    <div className="relative">
                      <User className="absolute left-3 top-3.5 text-gray-500" size={16} />
                      <input
                        type="text"
                        required
                        minLength={3}
                        maxLength={15}
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        placeholder="ex: DominoMaster"
                        className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 pl-10 pr-4 text-sm text-white placeholder-gray-600 focus:outline-none focus:border-amber-500/60 transition-all font-mono"
                      />
                    </div>
                  </div>

                  <div className="space-y-1">
                    <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Email</label>
                    <div className="relative">
                      <Mail className="absolute left-3 top-3.5 text-gray-500" size={16} />
                      <input
                        type="email"
                        required
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        placeholder="email@adresse.com"
                        className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 pl-10 pr-4 text-sm text-white placeholder-gray-600 focus:outline-none focus:border-amber-500/60 transition-all font-mono"
                      />
                    </div>
                  </div>

                  <div className="space-y-1">
                    <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Mot de passe</label>
                    <div className="relative">
                      <Lock className="absolute left-3 top-3.5 text-gray-500" size={16} />
                      <input
                        type="password"
                        required
                        minLength={6}
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        placeholder="Min. 6 caractères"
                        className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 pl-10 pr-4 text-sm text-white placeholder-gray-600 focus:outline-none focus:border-amber-500/60 transition-all font-mono"
                      />
                    </div>
                  </div>

                  <button
                    type="button"
                    onClick={() => {
                      if (!username.trim() || username.length < 3) {
                        setErrorMsg("Le nom d'utilisateur doit contenir au moins 3 caractères.");
                        return;
                      }
                      if (!email || !email.includes("@")) {
                        setErrorMsg("Veuillez saisir un email valide.");
                        return;
                      }
                      if (password.length < 6) {
                        setErrorMsg("Le mot de passe doit contenir au moins 6 caractères.");
                        return;
                      }
                      setErrorMsg(null);
                      setRegStep(2);
                    }}
                    className="w-full flex items-center justify-center gap-2 py-3.5 rounded-xl font-bold text-sm bg-gradient-to-b from-amber-400 to-amber-600 text-black shadow-lg hover:brightness-110 active:scale-98 transition-all cursor-pointer"
                  >
                    <span>Continuer</span>
                    <ArrowRight size={16} />
                  </button>
                </div>
              )}

              {/* STEP 2: Country, Language & timezone */}
              {regStep === 2 && (
                <div className="space-y-4">
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
                        }
                      }}
                      className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 px-4 text-xs text-white focus:outline-none focus:border-amber-500/60 transition-all font-mono"
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
                      className="w-full bg-[#121212] border border-gray-800 rounded-xl py-2.5 px-3 text-xs text-white focus:outline-none focus:border-amber-500/60 transition-all font-mono"
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
                      className="w-full bg-[#121212] border border-gray-800 rounded-xl py-2.5 px-3 text-xs text-white focus:outline-none focus:border-amber-500/60 transition-all font-mono"
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

                  <div className="flex gap-2">
                    <button
                      type="button"
                      onClick={() => setRegStep(1)}
                      className="w-1/3 py-3 rounded-xl font-bold text-xs bg-[#181818] border border-gray-800 text-gray-400 hover:bg-[#202020] active:scale-98 transition-all cursor-pointer text-center"
                    >
                      Retour
                    </button>
                    <button
                      type="button"
                      onClick={() => {
                        if (!countryCode) {
                          setErrorMsg("Veuillez sélectionner un pays.");
                          return;
                        }
                        setErrorMsg(null);
                        setRegStep(3);
                      }}
                      className="w-2/3 py-3 rounded-xl font-bold text-xs bg-gradient-to-b from-amber-400 to-amber-600 text-black shadow-md hover:brightness-110 active:scale-98 transition-all cursor-pointer text-center"
                    >
                      Suivant
                    </button>
                  </div>
                </div>
              )}

              {/* STEP 3: Availabilities */}
              {regStep === 3 && (
                <div className="space-y-4">
                  {/* Disponibilités */}
                  <div className="space-y-3 pt-2">
                    <div className="space-y-1">
                      <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block text-center">
                        Heures de disponibilité
                      </label>
                      <div className="grid grid-cols-4 gap-2 pt-2">
                        {HOURS_24.map((hour) => {
                          const isSelected = selectedHours.includes(hour);
                          return (
                            <button
                              key={hour}
                              type="button"
                              onClick={() => toggleHour(hour)}
                              className={`py-3.5 rounded-xl text-xs font-bold text-center transition-all border cursor-pointer ${
                                isSelected
                                  ? "bg-amber-500/20 border-amber-500 text-amber-400"
                                  : "bg-[#121212] border-gray-850 text-gray-300 hover:border-gray-700"
                              }`}
                            >
                              {hour}
                            </button>
                          );
                        })}
                      </div>
                    </div>
                  </div>

                  <div className="flex gap-2 pt-2">
                    <button
                      type="button"
                      onClick={() => setRegStep(2)}
                      className="w-1/3 py-3 rounded-xl font-bold text-xs bg-[#181818] border border-gray-800 text-gray-400 hover:bg-[#202020] active:scale-98 transition-all cursor-pointer text-center"
                    >
                      Retour
                    </button>
                    <button
                      type="submit"
                      disabled={loading}
                      className="w-2/3 py-3 rounded-xl font-bold text-xs bg-gradient-to-b from-amber-400 to-amber-600 text-black shadow-md hover:brightness-110 active:scale-98 transition-all cursor-pointer text-center"
                    >
                      {loading ? "Création..." : "S'inscrire"}
                    </button>
                  </div>
                </div>
              )}
            </form>
          )}

          {view === "forgot" && (
            <form onSubmit={handleForgotPassword} className="space-y-4">
              <div className="space-y-1">
                <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Email</label>
                <div className="relative">
                  <Mail className="absolute left-3 top-3.5 text-gray-500" size={16} />
                  <input
                    type="email"
                    required
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    placeholder="email@adresse.com"
                    className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 pl-10 pr-4 text-sm text-white placeholder-gray-600 focus:outline-none focus:border-amber-500/60 transition-all font-mono"
                  />
                </div>
              </div>

              <button
                type="submit"
                disabled={loading}
                className="w-full flex items-center justify-center gap-2 py-3.5 rounded-xl font-bold text-sm bg-[#181818] border border-gray-800 text-amber-500 shadow-md hover:bg-[#202020] active:scale-98 transition-all cursor-pointer"
              >
                <Key size={16} />
                <span>{loading ? "Envoi..." : "Envoyer l'email de récupération"}</span>
              </button>

              <button
                type="button"
                onClick={() => setView("login")}
                className="w-full text-center text-xs text-gray-500 hover:text-white transition-all py-1.5 cursor-pointer"
              >
                Retourner à la connexion
              </button>
            </form>
          )}

          {view === "reset-password" && (
            <form onSubmit={handleUpdatePassword} className="space-y-4">
              <div className="space-y-1">
                <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Nouveau mot de passe</label>
                <div className="relative">
                  <Lock className="absolute left-3 top-3.5 text-gray-500" size={16} />
                  <input
                    type="password"
                    required
                    minLength={6}
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    placeholder="Min. 6 caractères"
                    className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 pl-10 pr-4 text-sm text-white placeholder-gray-600 focus:outline-none focus:border-amber-500/60 transition-all font-mono"
                  />
                </div>
              </div>

              <button
                type="submit"
                disabled={loading}
                className="w-full flex items-center justify-center gap-2 py-3.5 rounded-xl font-bold text-sm bg-gradient-to-b from-amber-400 to-amber-600 text-black shadow-lg shadow-amber-900/10 hover:brightness-110 active:scale-98 transition-all cursor-pointer"
              >
                <span>{loading ? "Mise à jour..." : "Mettre à jour le mot de passe"}</span>
                <ArrowRight size={16} />
              </button>

              <button
                type="button"
                onClick={() => setView("login")}
                className="w-full text-center text-xs text-gray-500 hover:text-white transition-all py-1.5 cursor-pointer"
              >
                Retourner à la connexion
              </button>
            </form>
          )}

          {/* Toggle register / login link */}
          {view !== "forgot" && view !== "reset-password" && (
            <div className="text-center pt-2 text-xs">
              <span className="text-gray-500">
                {view === "login" ? "Pas encore de compte ?" : "Déjà un compte ?"}
              </span>{" "}
              <button
                onClick={() => setView(view === "login" ? "register" : "login")}
                className="text-amber-500 font-bold hover:underline cursor-pointer"
              >
                {view === "login" ? "S'inscrire" : "Se connecter"}
              </button>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
