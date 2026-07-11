import React, { createContext, useContext, useState, useEffect } from "react";
import fr from "./fr.json";
import ht from "./ht.json";
import en from "./en.json";
import es from "./es.json";
import pt from "./pt.json";

const translations: Record<string, any> = { fr, ht, en, es, pt };

export const supportedLanguages = [
  { code: "fr", name: "Français", flag: "🇫🇷" },
  { code: "ht", name: "Kreyòl", flag: "🇭🇹" },
  { code: "en", name: "English", flag: "🇺🇸" },
  { code: "es", name: "Español", flag: "🇪🇸" },
  { code: "pt", name: "Português", flag: "🇧🇷" }
];

export type Language = "fr" | "ht" | "en" | "es" | "pt";

interface LanguageContextType {
  language: Language;
  setLanguage: (lang: Language) => void;
  t: (key: string, replacements?: Record<string, string | number>) => string;
}

const LanguageContext = createContext<LanguageContextType | undefined>(undefined);

export const LanguageProvider: React.FC<{ children: React.ReactNode; defaultLang?: Language }> = ({ children, defaultLang = "fr" }) => {
  const [language, setLanguageState] = useState<Language>(() => {
    return (localStorage.getItem("maestro_domino_lang") as Language) || defaultLang;
  });

  const setLanguage = (lang: Language) => {
    setLanguageState(lang);
    localStorage.setItem("maestro_domino_lang", lang);
  };

  const t = (key: string, replacements?: Record<string, string | number>): string => {
    const dict = translations[language] || translations["fr"];
    
    // Resolve nested keys e.g. "auth.login"
    const keys = key.split(".");
    let value = dict;
    for (const k of keys) {
      if (value && typeof value === "object" && k in value) {
        value = value[k];
      } else {
        value = undefined;
        break;
      }
    }

    if (typeof value !== "string") {
      // Fallback to French
      let fallbackValue = translations["fr"];
      for (const k of keys) {
        if (fallbackValue && typeof fallbackValue === "object" && k in fallbackValue) {
          fallbackValue = fallbackValue[k];
        } else {
          fallbackValue = undefined;
          break;
        }
      }
      if (typeof fallbackValue === "string") {
        value = fallbackValue;
      } else {
        return key;
      }
    }

    if (replacements) {
      let str = value;
      Object.entries(replacements).forEach(([k, v]) => {
        str = str.replace(`{${k}}`, String(v));
      });
      return str;
    }

    return value;
  };

  return (
    <LanguageContext.Provider value={{ language, setLanguage, t }}>
      {children}
    </LanguageContext.Provider>
  );
};

export const useTranslation = () => {
  const context = useContext(LanguageContext);
  if (!context) {
    throw new Error("useTranslation must be used within a LanguageProvider");
  }
  return context;
};
