/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import React, { useEffect, useState, useRef } from "react";
import { X, Download, Share, Plus } from "lucide-react";

// ─── Types ───────────────────────────────────────────────────────────────────

type Platform = "android" | "ios" | "desktop" | "unknown";

interface BeforeInstallPromptEvent extends Event {
  prompt: () => Promise<void>;
  userChoice: Promise<{ outcome: "accepted" | "dismissed" }>;
}

// ─── Helpers ─────────────────────────────────────────────────────────────────

/** Returns true when app is already running as installed PWA (standalone mode). */
const isRunningStandalone = (): boolean => {
  return (
    window.matchMedia("(display-mode: standalone)").matches ||
    // iOS Safari sets this
    (navigator as any).standalone === true
  );
};

/** Detect the user's platform. */
const detectPlatform = (): Platform => {
  const ua = navigator.userAgent.toLowerCase();
  if (/iphone|ipad|ipod/.test(ua)) return "ios";
  if (/android/.test(ua)) return "android";
  if (/windows|macintosh|linux/.test(ua)) return "desktop";
  return "unknown";
};

/** Returns true if user already permanently dismissed the prompt. */
const wasDismissed = (): boolean => {
  const ts = localStorage.getItem("maestro_install_dismissed_at");
  if (!ts) return false;
  // Re-show after 7 days
  const dismissedAt = parseInt(ts, 10);
  return Date.now() - dismissedAt < 7 * 24 * 60 * 60 * 1000;
};

const dismiss = () => {
  localStorage.setItem("maestro_install_dismissed_at", String(Date.now()));
};

// ─── Component ───────────────────────────────────────────────────────────────

export const InstallPrompt: React.FC = () => {
  const [platform, setPlatform] = useState<Platform>("unknown");
  const [visible, setVisible] = useState(false);
  const [installed, setInstalled] = useState(false);
  const [step, setStep] = useState<"prompt" | "ios-guide">("prompt");
  const deferredPromptRef = useRef<BeforeInstallPromptEvent | null>(null);

  useEffect(() => {
    // Already installed → never show
    if (isRunningStandalone()) {
      setInstalled(true);
      return;
    }
    // User already dismissed → skip
    if (wasDismissed()) return;

    const plat = detectPlatform();
    setPlatform(plat);

    // Android / Chrome: capture the native install event
    const onBeforeInstall = (e: Event) => {
      e.preventDefault();
      deferredPromptRef.current = e as BeforeInstallPromptEvent;
      // Show our custom banner after a short delay so it doesn't feel jarring
      setTimeout(() => setVisible(true), 1500);
    };

    window.addEventListener("beforeinstallprompt", onBeforeInstall);

    // iOS: no beforeinstallprompt — show manual guide
    if (plat === "ios") {
      setTimeout(() => setVisible(true), 2000);
    }

    // Listen for app install (Android) — hide banner once installed
    const onAppInstalled = () => {
      setInstalled(true);
      setVisible(false);
    };
    window.addEventListener("appinstalled", onAppInstalled);

    return () => {
      window.removeEventListener("beforeinstallprompt", onBeforeInstall);
      window.removeEventListener("appinstalled", onAppInstalled);
    };
  }, []);

  const handleInstallAndroid = async () => {
    const prompt = deferredPromptRef.current;
    if (!prompt) return;
    await prompt.prompt();
    const { outcome } = await prompt.userChoice;
    if (outcome === "accepted") {
      setInstalled(true);
      setVisible(false);
    } else {
      handleClose();
    }
    deferredPromptRef.current = null;
  };

  const handleClose = () => {
    dismiss();
    setVisible(false);
  };

  // Nothing to show
  if (!visible || installed) return null;

  // ── Android Banner ────────────────────────────────────────────────────────
  if (platform === "android") {
    return (
      <div
        className="fixed bottom-0 left-0 right-0 z-[10000] safe-area-bottom"
        style={{ animation: "slideUpIn 0.4s cubic-bezier(0.22,1,0.36,1) both" }}
      >
        <style>{`
          @keyframes slideUpIn {
            from { transform: translateY(100%); opacity: 0; }
            to   { transform: translateY(0);    opacity: 1; }
          }
          @keyframes pulse-glow {
            0%, 100% { box-shadow: 0 0 0 0 rgba(245,158,11,0.4); }
            50%       { box-shadow: 0 0 0 8px rgba(245,158,11,0); }
          }
        `}</style>

        <div className="mx-3 mb-3 rounded-2xl overflow-hidden border border-amber-500/30 shadow-2xl"
          style={{ background: "linear-gradient(135deg, #1a1208 0%, #0f0c04 100%)" }}>
          {/* Glow accent bar */}
          <div className="h-0.5 w-full bg-gradient-to-r from-amber-600 via-yellow-400 to-amber-600" />

          <div className="p-4">
            {/* Header */}
            <div className="flex items-start justify-between mb-3">
              <div className="flex items-center gap-3">
                <div className="w-12 h-12 rounded-xl overflow-hidden shadow-lg shrink-0"
                  style={{ animation: "pulse-glow 2s ease-in-out infinite" }}>
                  <img src="/Maesto.png" alt="Maestro Domino" className="w-full h-full object-cover" />
                </div>
                <div>
                  <p className="text-white font-bold text-base leading-tight">Maestro Domino</p>
                  <p className="text-amber-400 text-xs font-medium">maestro-sooty.vercel.app</p>
                  <div className="flex items-center gap-1 mt-0.5">
                    <span className="w-1.5 h-1.5 rounded-full bg-emerald-400 inline-block" />
                    <span className="text-[10px] text-emerald-400 font-medium">Gratuit · Aucun espace requis</span>
                  </div>
                </div>
              </div>
              <button onClick={handleClose}
                className="text-gray-500 hover:text-gray-300 transition-colors p-1 -mr-1 -mt-1 cursor-pointer">
                <X size={18} />
              </button>
            </div>

            {/* Description */}
            <p className="text-gray-400 text-xs mb-4 leading-relaxed">
              Installez l'application sur votre téléphone pour jouer hors-ligne, accéder plus rapidement et profiter d'une expérience plein écran.
            </p>

            {/* CTA buttons */}
            <div className="flex gap-2">
              <button
                onClick={handleInstallAndroid}
                className="flex-1 flex items-center justify-center gap-2 bg-amber-500 hover:bg-amber-400 active:bg-amber-600 text-black font-bold text-sm py-3 px-4 rounded-xl transition-all duration-150 cursor-pointer"
                style={{ boxShadow: "0 4px 20px rgba(245,158,11,0.4)" }}
              >
                <Download size={16} />
                Installer l'application
              </button>
              <button
                onClick={handleClose}
                className="px-4 py-3 rounded-xl border border-gray-700 text-gray-400 hover:text-gray-200 text-sm transition-colors cursor-pointer"
              >
                Plus tard
              </button>
            </div>
          </div>
        </div>
      </div>
    );
  }

  // ── iOS Banner ────────────────────────────────────────────────────────────
  if (platform === "ios") {
    return (
      <div
        className="fixed bottom-0 left-0 right-0 z-[10000]"
        style={{ animation: "slideUpIn 0.4s cubic-bezier(0.22,1,0.36,1) both" }}
      >
        <style>{`
          @keyframes slideUpIn {
            from { transform: translateY(100%); opacity: 0; }
            to   { transform: translateY(0);    opacity: 1; }
          }
          @keyframes bounce-arrow {
            0%, 100% { transform: translateY(0); }
            50%       { transform: translateY(4px); }
          }
        `}</style>

        <div className="mx-3 mb-3 rounded-2xl overflow-hidden border border-blue-500/30 shadow-2xl"
          style={{ background: "linear-gradient(135deg, #080d1a 0%, #040810 100%)" }}>
          <div className="h-0.5 w-full bg-gradient-to-r from-blue-600 via-sky-400 to-blue-600" />

          <div className="p-4">
            <div className="flex items-start justify-between mb-3">
              <div className="flex items-center gap-3">
                <div className="w-12 h-12 rounded-xl overflow-hidden shadow-lg shrink-0">
                  <img src="/Maesto.png" alt="Maestro Domino" className="w-full h-full object-cover" />
                </div>
                <div>
                  <p className="text-white font-bold text-base">Maestro Domino</p>
                  <p className="text-blue-400 text-xs font-medium">Disponible sur iPhone</p>
                </div>
              </div>
              <button onClick={handleClose}
                className="text-gray-500 hover:text-gray-300 transition-colors p-1 -mr-1 -mt-1 cursor-pointer">
                <X size={18} />
              </button>
            </div>

            {step === "prompt" ? (
              <>
                <p className="text-gray-400 text-xs mb-4 leading-relaxed">
                  Ajoutez Maestro Domino à votre écran d'accueil pour un accès instantané — comme une vraie app native.
                </p>
                <button
                  onClick={() => setStep("ios-guide")}
                  className="w-full flex items-center justify-center gap-2 bg-blue-600 hover:bg-blue-500 active:bg-blue-700 text-white font-bold text-sm py-3 px-4 rounded-xl transition-all cursor-pointer"
                  style={{ boxShadow: "0 4px 20px rgba(59,130,246,0.4)" }}
                >
                  <Plus size={16} />
                  Comment installer ?
                </button>
              </>
            ) : (
              <>
                <p className="text-white font-semibold text-sm mb-3">Suivez ces étapes dans Safari :</p>
                <div className="space-y-2.5">
                  {/* Step 1 */}
                  <div className="flex items-center gap-3 bg-white/5 rounded-xl p-2.5">
                    <div className="w-7 h-7 rounded-full bg-blue-600 flex items-center justify-center text-white text-xs font-bold shrink-0">1</div>
                    <div className="flex-1">
                      <p className="text-white text-xs font-medium">Appuyez sur</p>
                      <p className="text-blue-300 text-xs">le bouton Partager <Share size={11} className="inline" /></p>
                    </div>
                    <div className="w-8 h-8 rounded-lg bg-blue-500/20 border border-blue-500/40 flex items-center justify-center">
                      <Share size={14} className="text-blue-400" />
                    </div>
                  </div>

                  {/* Step 2 */}
                  <div className="flex items-center gap-3 bg-white/5 rounded-xl p-2.5">
                    <div className="w-7 h-7 rounded-full bg-blue-600 flex items-center justify-center text-white text-xs font-bold shrink-0">2</div>
                    <div className="flex-1">
                      <p className="text-white text-xs font-medium">Faites défiler et choisissez</p>
                      <p className="text-blue-300 text-xs">"Sur l'écran d'accueil"</p>
                    </div>
                    <div className="w-8 h-8 rounded-lg bg-blue-500/20 border border-blue-500/40 flex items-center justify-center">
                      <Plus size={14} className="text-blue-400" />
                    </div>
                  </div>

                  {/* Step 3 */}
                  <div className="flex items-center gap-3 bg-white/5 rounded-xl p-2.5">
                    <div className="w-7 h-7 rounded-full bg-blue-600 flex items-center justify-center text-white text-xs font-bold shrink-0">3</div>
                    <div className="flex-1">
                      <p className="text-white text-xs font-medium">Confirmez en appuyant</p>
                      <p className="text-blue-300 text-xs">sur "Ajouter" en haut à droite</p>
                    </div>
                  </div>
                </div>

                {/* Arrow pointing down (to the Safari share button) */}
                <div className="flex justify-center mt-3" style={{ animation: "bounce-arrow 1.5s ease-in-out infinite" }}>
                  <div className="text-blue-400 text-xs font-medium text-center">
                    ↓ Bouton Partager en bas de Safari
                  </div>
                </div>
              </>
            )}
          </div>
        </div>
      </div>
    );
  }

  // Desktop or unknown: no banner
  return null;
};
