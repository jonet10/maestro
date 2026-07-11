export interface DbAvailability {
  day_of_week: number;
  start_time: string;
  end_time: string;
  timezone: string;
  type: string;
}

export function checkAvailabilityNow(availabilities: DbAvailability[]): { available: boolean; text: string } {
  if (!availabilities || availabilities.length === 0) {
    return { available: false, text: "Aucune disponibilité" };
  }

  // Get current time in the first availability's timezone (or fall back to local timezone)
  const targetTimezone = availabilities[0]?.timezone || Intl.DateTimeFormat().resolvedOptions().timeZone;

  try {
    const formatter = new Intl.DateTimeFormat('en-US', {
      timeZone: targetTimezone,
      weekday: 'long',
      hour: 'numeric',
      minute: 'numeric',
      hour12: false
    });
    
    const formatted = formatter.format(new Date()); // e.g. "Monday, 19:42"
    const parts = formatted.toLowerCase().split(", ");
    if (parts.length < 2) {
      return { available: false, text: "Indisponible" };
    }
    const dayName = parts[0];
    const timePart = parts[1];
    
    const dayMap: Record<string, number> = {
      "sunday": 0, "monday": 1, "tuesday": 2, "wednesday": 3,
      "thursday": 4, "friday": 5, "saturday": 6
    };
    const currentDay = dayMap[dayName] !== undefined ? dayMap[dayName] : 1;
    const [currentH, currentM] = timePart.split(":").map(Number);
    const currentMinutes = currentH * 60 + currentM;

    // Check if currently available
    const activeSlot = availabilities.find(slot => {
      if (slot.day_of_week !== currentDay) return false;
      const [sh, sm] = slot.start_time.split(":").map(Number);
      const [eh, em] = slot.end_time.split(":").map(Number);
      const startMin = sh * 60 + sm;
      const endMin = eh * 60 + em;
      return currentMinutes >= startMin && currentMinutes < endMin;
    });

    if (activeSlot) {
      return { available: true, text: "Disponible maintenant" };
    }

    // Otherwise, find the next slot
    // Sort availabilities starting from today's day of week, then time
    const sorted = [...availabilities].sort((a, b) => {
      const diffA = (a.day_of_week - currentDay + 7) % 7;
      const diffB = (b.day_of_week - currentDay + 7) % 7;
      if (diffA !== diffB) return diffA - diffB;
      return a.start_time.localeCompare(b.start_time);
    });

    const next = sorted[0];
    const daysFr = ["Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"];
    const dayLabel = daysFr[next.day_of_week];
    const startHour = next.start_time.substring(0, 5).replace(":", "h");
    const endHour = next.end_time.substring(0, 5).replace(":", "h");
    return {
      available: false,
      text: `Dispo ${dayLabel} ${startHour} - ${endHour}`
    };
  } catch (err) {
    console.error("Error formatting timezone date:", err);
    return { available: false, text: "Indisponible" };
  }
}
