export interface CountryInfo {
  code: string;
  name: string;
  flag: string;
  defaultLang: string;
  defaultTimezone: string;
}

export const COUNTRIES: CountryInfo[] = [
  { code: "HT", name: "Haïti", flag: "🇭🇹", defaultLang: "ht", defaultTimezone: "America/Port-au-Prince" },
  { code: "FR", name: "France", flag: "🇫🇷", defaultLang: "fr", defaultTimezone: "Europe/Paris" },
  { code: "CA", name: "Canada", flag: "🇨🇦", defaultLang: "en", defaultTimezone: "America/Toronto" },
  { code: "US", name: "États-Unis", flag: "🇺🇸", defaultLang: "en", defaultTimezone: "America/New_York" },
  { code: "DO", name: "République Dominicaine", flag: "🇩🇴", defaultLang: "es", defaultTimezone: "America/Santo_Domingo" },
  { code: "BR", name: "Brésil", flag: "🇧🇷", defaultLang: "pt", defaultTimezone: "America/Sao_Paulo" }
];

export function getCountryByCode(code: string): CountryInfo | undefined {
  return COUNTRIES.find(c => c.code.toUpperCase() === code.toUpperCase());
}
