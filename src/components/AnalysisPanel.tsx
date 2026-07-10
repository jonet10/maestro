/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import React from "react";
import { GeneralAnalysis, PipCount } from "../types";
import { BarChart3, TrendingUp, ShieldAlert, Cpu, Layers } from "lucide-react";

interface AnalysisPanelProps {
  analysis: GeneralAnalysis;
  gameMode: string;
}

/**
 * Strategy Dashboard Panel representing real-time tactical board conditions,
 * remaining tile distribution heatmaps, and opponent pip estimators.
 */
export const AnalysisPanel: React.FC<AnalysisPanelProps> = ({ analysis, gameMode }) => {
  const {
    openLeft,
    openRight,
    playedCount,
    boneyardCount,
    pipStats,
    estimatedOpponentStrengths,
    dominantPips,
    handSafetyAverage,
  } = analysis;

  const renderDistributionBar = (stat: PipCount) => {
    // Total is 7. We calculate percentages of Played, In Hand, Unknown.
    const playedWidth = (stat.played / 7) * 100;
    const handWidth = (stat.inHand / 7) * 100;
    const unknownWidth = (stat.unknown / 7) * 100;

    return (
      <div key={stat.pip} className="flex flex-col sm:flex-row items-start sm:items-center justify-between gap-1.5 py-2.5 border-b border-gray-800/40 last:border-0 text-xs text-gray-300">
        <div className="flex items-center gap-2 mb-1 sm:mb-0">
          <span className="h-5 w-5 rounded-full bg-gray-800/80 border border-gray-700 text-xxs font-mono font-bold flex items-center justify-center text-amber-400 select-none">
            {stat.pip}
          </span>
          <span className="font-sans font-medium text-gray-200">Pip {stat.pip}</span>
        </div>

        {/* Stacked distribution strip */}
        <div className="w-full sm:w-[150px] md:w-[180px] lg:w-[220px] xl:w-[250px] h-3 bg-gray-900 rounded-full overflow-hidden flex shadow-inner">
          {stat.played > 0 && (
            <div
              style={{ width: `${playedWidth}%` }}
              className="bg-gray-500/80 h-full transition-all duration-500 hover:brightness-110"
              title={`${stat.played} played on board`}
            />
          )}
          {stat.inHand > 0 && (
            <div
              style={{ width: `${handWidth}%` }}
              className="bg-amber-500 h-full transition-all duration-500 hover:brightness-110"
              title={`${stat.inHand} in your hand`}
            />
          )}
          {stat.unknown > 0 && (
            <div
              style={{ width: `${unknownWidth}%` }}
              className="bg-gray-850 h-full transition-all duration-500 hover:brightness-110"
              title={`${stat.unknown} unknown (in boneyard or opponent hand)`}
            />
          )}
        </div>

        {/* Details label */}
        <div className="flex gap-2 font-mono text-[10px] text-gray-400 self-end sm:self-center">
          <span>{stat.played}P / {stat.inHand}H / <strong className="text-gray-300">{stat.unknown}U</strong></span>
        </div>
      </div>
    );
  };

  // Determine flex label colors
  const getSafetyColor = (score: number) => {
    if (score >= 70) return "text-amber-400 bg-amber-500/10 border-amber-500/20";
    if (score >= 40) return "text-yellow-400 bg-yellow-500/10 border-yellow-500/20";
    return "text-red-400 bg-red-500/10 border-red-500/20";
  };

  return (
    <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
      
      {/* 1. PIP DISTRIBUTION CHART CARD */}
      <div className="lg:col-span-2 bg-[#101010] border border-gray-800 rounded-2xl p-5 shadow-lg flex flex-col justify-between">
        <div className="space-y-1 mb-4">
          <h2 className="font-sans font-semibold text-gray-100 text-base flex items-center gap-2">
            <Layers className="text-amber-400" size={18} />
            <span>Double-Six Pip Distribution</span>
          </h2>
          <p className="text-xs text-gray-400">
            Analysis of all 28 tiles in play. Counts represent: <span className="text-gray-500">Played (■)</span>, <span className="text-amber-500">In Hand (■)</span>, and <span className="text-gray-300 font-bold">Unknown (■)</span>.
          </p>
        </div>

        <div className="space-y-1">
          {pipStats.map(stat => renderDistributionBar(stat))}
        </div>
        
        {/* Footer info explaining counts */}
        <div className="mt-4 pt-3 border-t border-gray-800/30 flex justify-between items-center text-[10px] text-gray-500 font-mono">
          <span>Tiles Played: {playedCount}</span>
          <span>Boneyard Pool: {boneyardCount}</span>
          <span>Your Hand: {pipStats.reduce((sum, s) => sum + s.inHand, 0)}</span>
        </div>
      </div>

      {/* 2. PROBABILITY & TACTICAL METERS CARD */}
      <div className="space-y-6 lg:col-span-1">
        
        {/* Safe Flexibility Gauge */}
        <div className="bg-[#101010] border border-gray-800 rounded-2xl p-5 shadow-lg space-y-4">
          <h3 className="font-sans font-semibold text-gray-100 text-sm flex items-center gap-2">
            <TrendingUp className="text-amber-400" size={16} />
            <span>Hand Resilience Meter</span>
          </h3>
          
          <div className="flex items-center gap-4">
            <div className={`text-3xl font-black font-mono tracking-tight px-3 py-1.5 rounded-xl border ${getSafetyColor(handSafetyAverage)} shadow`}>
              {handSafetyAverage}%
            </div>
            <div className="space-y-0.5 flex-1 p-0.5">
              <span className="text-xs font-semibold text-gray-200">
                {handSafetyAverage >= 70 ? "Flexible holdings" : handSafetyAverage >= 40 ? "Balanced risk" : "Vulnerable hand"}
              </span>
              <p className="text-xxs text-gray-400">
                Calculates your count of follow-ups if blocked. A higher percentage indicates you are highly resilient to opposing traps.
              </p>
            </div>
          </div>
        </div>

        {/* Dynamic Opponent Holdings Probabilities */}
        <div className="bg-[#101010] border border-gray-800 rounded-2xl p-5 shadow-lg space-y-4">
          <h3 className="font-sans font-semibold text-gray-100 text-sm flex items-center gap-2">
            <Cpu className="text-yellow-400" size={16} />
            <span>Opponent holdings predictor</span>
          </h3>
          <p className="text-xxs text-gray-400">
            Estimated likelihood opponent holds at least one tile of each pip, calculated by remaining pool sizes.
          </p>

          <div className="grid grid-cols-7 gap-1.5 pt-1">
            {Object.keys(estimatedOpponentStrengths).map(k => {
              const pip = Number(k);
              const prob = estimatedOpponentStrengths[pip];

              let barColor = "bg-yellow-600";
              if (prob >= 80) barColor = "bg-yellow-400";
              if (prob === 0) barColor = "bg-gray-800";

              return (
                <div key={pip} className="flex flex-col items-center gap-1.5 p-1 rounded bg-[#101114] border border-gray-800/20">
                  <span className="font-mono text-xxs text-gray-400 font-bold">{pip}</span>
                  <div className="w-[8px] h-12 bg-gray-900 rounded-full flex flex-col justify-end overflow-hidden">
                    <div
                      style={{ height: `${prob}%` }}
                      className={`${barColor} w-full transition-all duration-500 rounded-full`}
                    />
                  </div>
                  <span className="text-[8px] font-mono font-medium text-gray-500">{prob === 0 ? "0%" : `${prob}%`}</span>
                </div>
              );
            })}
          </div>
        </div>

        {/* Choke Points warnings */}
        <div className="bg-[#101010] border border-gray-800 rounded-2xl p-5 shadow-lg space-y-3">
          <h3 className="font-sans font-semibold text-gray-100 text-sm flex items-center gap-2">
            <ShieldAlert className="text-red-400" size={16} />
            <span>Tactical Warnings</span>
          </h3>

          <div className="space-y-2 text-xxs text-gray-300">
            {dominantPips.length > 0 ? (
              dominantPips.map(pip => (
                <div key={pip} className="flex items-start gap-2 p-2 bg-red-950/20 border border-red-900/30 rounded-lg text-red-300">
                  <span className="shrink-0 mt-0.5">⚠️</span>
                  <div>
                    <span className="font-bold">Choke Danger: Pip {pip} depleted!</span>
                    <p className="text-red-400/80 mt-0.5">
                      This pip is nearly fully spent ({pipStats[pip]?.played} occurrences played). Connecting onto this end has a very high chance of locking the opponent, or clogging the board.
                    </p>
                  </div>
                </div>
              ))
            ) : (
              <div className="flex items-center gap-2 p-2.5 bg-gray-900 rounded-lg text-gray-400">
                <span>✓</span>
                <span>No severe choke points detected. Board flow is open and balanced.</span>
              </div>
            )}

            {/* General advice based on current open end options */}
            {openLeft !== null && openRight !== null && (
              <div className="p-2.5 bg-gray-900 rounded-lg space-y-0.5 text-gray-400">
                <span className="text-[10px] font-semibold text-gray-300 block">Game Mode Rules:</span>
                {gameMode === "all-fives" ? (
                  <span>Sum of ends is <strong className="text-amber-400">{openLeft + openRight}</strong>. Scoring opportunity requires a multiple of 5 (e.g. {Math.ceil((openLeft+openRight)/5)*5}).</span>
                ) : (
                  <span>Play ends matching {openLeft} or {openRight}. Prefer playing doubles or higher pip totals to score high of remaining hand.</span>
                )}
              </div>
            )}
          </div>
        </div>

      </div>

    </div>
  );
};
