const fs = require('fs');
const http = require('https');

function getFlagEmoji(countryCode) {
  const codePoints = countryCode
    .toUpperCase()
    .split('')
    .map(char => 127397 + char.charCodeAt(0));
  return String.fromCodePoint(...codePoints);
}

// Map common languages to our supported language codes
function mapLanguage(langs) {
  if (!langs) return 'en';
  const keys = Object.keys(langs);
  if (keys.includes('fra')) return 'fr';
  if (keys.includes('hat')) return 'ht';
  if (keys.includes('spa')) return 'es';
  if (keys.includes('por')) return 'pt';
  if (keys.includes('eng')) return 'en';
  return 'en'; // default fallback
}

// Map country codes to their major default timezones if it returns offset format
const timezoneFallbacks = {
  "HT": "America/Port-au-Prince",
  "FR": "Europe/Paris",
  "CA": "America/Toronto",
  "US": "America/New_York",
  "DO": "America/Santo_Domingo",
  "BR": "America/Sao_Paulo",
  "GP": "America/Guadeloupe",
  "MQ": "America/Martinique",
  "GF": "America/Cayenne",
  "RE": "Indian/Reunion",
  "YT": "Indian/Mayotte"
};

function mapTimezone(countryCode, timezones) {
  if (timezoneFallbacks[countryCode]) {
    return timezoneFallbacks[countryCode];
  }
  if (!timezones || timezones.length === 0) return 'UTC';
  
  // Find the first zone that looks like an IANA timezone (contains '/')
  const iana = timezones.find(z => z.includes('/'));
  if (iana) return iana;
  
  // Otherwise try to convert offset (e.g. UTC+01:00)
  const offset = timezones[0]; // e.g. "UTC+01:00"
  return offset;
}

console.log("Fetching country list from restcountries.com API...");
http.get('https://restcountries.com/v3.1/all', (res) => {
  let data = '';
  res.on('data', (chunk) => { data += chunk; });
  res.on('end', () => {
    try {
      const countriesRaw = JSON.parse(data);
      console.log(`Fetched ${countriesRaw.length} countries.`);
      
      const countries = countriesRaw.map(c => {
        const code = c.cca2;
        const name = c.translations && c.translations.fra && c.translations.fra.common 
          ? c.translations.fra.common 
          : c.name.common;
        const flag = getFlagEmoji(code);
        const defaultLang = mapLanguage(c.languages);
        const defaultTimezone = mapTimezone(code, c.timezones);
        
        return { code, name, flag, defaultLang, defaultTimezone };
      });
      
      // Sort alphabetically by French name
      countries.sort((a, b) => a.name.localeCompare(b.name, 'fr'));
      
      // Output file content
      const fileContent = `export interface CountryInfo {
  code: string;
  name: string;
  flag: string;
  defaultLang: string;
  defaultTimezone: string;
}

export const COUNTRIES: CountryInfo[] = ${JSON.stringify(countries, null, 2)};

export function getCountryByCode(code: string): CountryInfo | undefined {
  return COUNTRIES.find(c => c.code.toUpperCase() === code.toUpperCase());
}
`;
      
      fs.writeFileSync('src/utils/countryData.ts', fileContent);
      console.log("Saved complete country list to src/utils/countryData.ts successfully.");
    } catch (err) {
      console.error("Error processing data:", err);
    }
  });
}).on('error', (err) => {
  console.error("HTTP error:", err);
});
