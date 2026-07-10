import React, { useState, useEffect } from "react";
import { supabase } from "../utils/supabaseClient";
import { Mail, Lock, User, AlertCircle, Key, ChevronLeft, ArrowRight, Sparkles } from "lucide-react";

const DAYS_OF_WEEK = [
  { id: "monday", label: "Lundi" },
  { id: "tuesday", label: "Mardi" },
  { id: "wednesday", label: "Mercredi" },
  { id: "thursday", label: "Jeudi" },
  { id: "friday", label: "Vendredi" },
  { id: "saturday", label: "Samedi" },
  { id: "sunday", label: "Dimanche" },
];

const TIME_SLOTS = [
  { id: "06-09", label: "06h - 09h" },
  { id: "09-12", label: "09h - 12h" },
  { id: "12-15", label: "12h - 15h" },
  { id: "15-18", label: "15h - 18h" },
  { id: "18-21", label: "18h - 21h" },
  { id: "21-00", label: "21h - 00h" },
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
  const [selectedDays, setSelectedDays] = useState<string[]>([]);
  const [selectedTimeSlots, setSelectedTimeSlots] = useState<string[]>([]);

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
    if (selectedDays.length === 0) {
      setErrorMsg("Veuillez sélectionner au moins un jour de disponibilité.");
      return;
    }
    if (selectedTimeSlots.length === 0) {
      setErrorMsg("Veuillez sélectionner au moins une plage horaire.");
      return;
    }
    setLoading(true);
    setErrorMsg(null);
    setSuccessMsg(null);

    try {
      // Sign up the user with metadata (username and availability)
      const { error } = await supabase.auth.signUp({
        email,
        password,
        options: {
          data: {
            username: username.trim(),
            availability: {
              timezone: Intl.DateTimeFormat().resolvedOptions().timeZone,
              days: selectedDays,
              timeSlots: selectedTimeSlots
            }
          },
        },
      });

      if (error) {
        setErrorMsg(error.message);
      } else {
        setSuccessMsg("Inscription réussie ! Un email de confirmation a été envoyé.");
        setView("login");
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

              {/* Disponibilités */}
              <div className="space-y-3 pt-2 border-t border-gray-900">
                <div className="space-y-1">
                  <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">
                    Jours de disponibilité *
                  </label>
                  <div className="flex flex-wrap gap-1.5 pt-1">
                    {DAYS_OF_WEEK.map((day) => (
                      <button
                        key={day.id}
                        type="button"
                        onClick={() => toggleDay(day.id)}
                        className={`px-2.5 py-1.5 rounded-lg text-xs font-semibold transition-all border cursor-pointer ${
                          selectedDays.includes(day.id)
                            ? "bg-amber-500/20 border-amber-500 text-amber-400"
                            : "bg-[#121212] border-gray-850 text-gray-400 hover:border-gray-700"
                        }`}
                      >
                        {day.label}
                      </button>
                    ))}
                  </div>
                </div>

                <div className="space-y-1">
                  <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">
                    Heures de disponibilité *
                  </label>
                  <div className="grid grid-cols-3 gap-1.5 pt-1">
                    {TIME_SLOTS.map((slot) => (
                      <button
                        key={slot.id}
                        type="button"
                        onClick={() => toggleTimeSlot(slot.id)}
                        className={`py-1.5 rounded-lg text-xs font-semibold text-center transition-all border cursor-pointer ${
                          selectedTimeSlots.includes(slot.id)
                            ? "bg-emerald-500/20 border-emerald-500 text-emerald-400"
                            : "bg-[#121212] border-gray-850 text-gray-400 hover:border-gray-700"
                        }`}
                      >
                        {slot.label}
                      </button>
                    ))}
                  </div>
                </div>
              </div>

              <button
                type="submit"
                disabled={loading}
                className="w-full flex items-center justify-center gap-2 py-3.5 rounded-xl font-bold text-sm bg-gradient-to-b from-amber-400 to-amber-600 text-black shadow-lg shadow-amber-900/10 hover:brightness-110 active:scale-98 transition-all cursor-pointer"
              >
                <span>{loading ? "Création du compte..." : "Créer mon compte"}</span>
                <ArrowRight size={16} />
              </button>
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
