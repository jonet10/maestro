import React, { useState, useEffect, useRef } from 'react';
import { MessageSquare, Send, X, MessageCircle } from 'lucide-react';
import { motion, AnimatePresence } from 'framer-motion';
import { supabase } from '../utils/supabaseClient';
import { ChatMessage, PREDEFINED_QUICK_MESSAGES, fetchChatMessages, sendChatMessage } from '../services/chatService';

interface GameChatProps {
  roomId: string;
  currentUserId: string;
}

export const GameChat: React.FC<GameChatProps> = ({ roomId, currentUserId }) => {
  const [isOpen, setIsOpen] = useState(false);
  const [messages, setMessages] = useState<ChatMessage[]>([]);
  const [inputText, setInputText] = useState('');
  const [unreadCount, setUnreadCount] = useState(0);
  const messagesEndRef = useRef<HTMLDivElement>(null);

  const loadMessages = async () => {
    const data = await fetchChatMessages(roomId);
    setMessages(data);
  };

  useEffect(() => {
    loadMessages();

    if (!supabase) return;

    // Realtime subscription for new chat messages in this room
    const channel = supabase
      .channel(`public:chat_messages:room_id=eq.${roomId}`)
      .on(
        'postgres_changes',
        {
          event: 'INSERT',
          schema: 'public',
          table: 'chat_messages',
          filter: `room_id=eq.${roomId}`
        },
        async (payload) => {
          // Need to fetch sender details for new message if we want username
          // Simple workaround: just fetch the whole list again, or fetch single message
          // For simplicity and to ensure order, we just append it and fetch missing sender info if needed
          const newMsg = payload.new as ChatMessage;
          
          if (newMsg.sender_id !== currentUserId) {
            // Fetch sender profile
            const { data: profile } = await supabase.from('profiles').select('username, avatar_url').eq('id', newMsg.sender_id).single();
            newMsg.sender = profile;
            
            if (!isOpen) {
              setUnreadCount(prev => prev + 1);
            }
          } else {
            // It's our own message, sender info is not strictly needed for display (we show "Moi")
            newMsg.sender = { username: 'Moi', avatar_url: null };
          }

          setMessages(prev => [...prev, newMsg]);
        }
      )
      .subscribe();

    return () => {
      supabase.removeChannel(channel);
    };
  }, [roomId, currentUserId]);

  useEffect(() => {
    if (isOpen) {
      setUnreadCount(0);
      scrollToBottom();
    }
  }, [isOpen, messages]);

  const scrollToBottom = () => {
    messagesEndRef.current?.scrollIntoView({ behavior: 'smooth' });
  };

  const handleSend = async (e?: React.FormEvent) => {
    if (e) e.preventDefault();
    if (!inputText.trim()) return;

    const textToSend = inputText.trim();
    setInputText('');
    await sendChatMessage(roomId, currentUserId, textToSend, false);
  };

  const handleSendQuick = async (msg: string) => {
    await sendChatMessage(roomId, currentUserId, msg, true);
  };

  return (
    <div className="absolute bottom-6 right-6 z-40">
      {/* Floating Action Button */}
      <button
        onClick={() => setIsOpen(!isOpen)}
        className="w-12 h-12 bg-amber-600 hover:bg-amber-500 text-stone-950 rounded-full flex items-center justify-center shadow-lg transition-transform hover:scale-105 relative"
      >
        <MessageCircle size={24} />
        {unreadCount > 0 && !isOpen && (
          <span className="absolute -top-1 -right-1 w-5 h-5 bg-red-500 text-white text-[10px] font-bold rounded-full flex items-center justify-center border-2 border-stone-900">
            {unreadCount}
          </span>
        )}
      </button>

      {/* Chat Window */}
      <AnimatePresence>
        {isOpen && (
          <motion.div
            initial={{ opacity: 0, y: 20, scale: 0.95 }}
            animate={{ opacity: 1, y: 0, scale: 1 }}
            exit={{ opacity: 0, y: 20, scale: 0.95 }}
            className="absolute bottom-16 right-0 w-80 h-96 bg-stone-900/95 backdrop-blur-md border border-stone-800 rounded-2xl shadow-2xl flex flex-col overflow-hidden"
          >
            {/* Header */}
            <div className="p-3 bg-stone-950 border-b border-stone-800 flex justify-between items-center">
              <span className="text-sm font-bold text-amber-500 flex items-center gap-2">
                <MessageSquare size={16} /> Chat de la partie
              </span>
              <button onClick={() => setIsOpen(false)} className="text-stone-500 hover:text-white transition-colors">
                <X size={18} />
              </button>
            </div>

            {/* Messages Area */}
            <div className="flex-1 p-3 overflow-y-auto custom-scrollbar flex flex-col gap-3">
              {messages.length === 0 ? (
                <div className="text-center text-stone-500 text-xs mt-4">Aucun message pour le moment.</div>
              ) : (
                messages.map((msg, i) => {
                  const isMine = msg.sender_id === currentUserId;
                  return (
                    <div key={msg.id || i} className={`flex flex-col ${isMine ? 'items-end' : 'items-start'}`}>
                      {!isMine && (
                        <span className="text-[10px] text-stone-500 ml-1 mb-0.5 font-bold">
                          {msg.sender?.username || 'Adversaire'}
                        </span>
                      )}
                      <div 
                        className={`max-w-[85%] p-2 rounded-xl text-sm ${
                          isMine 
                            ? 'bg-amber-600 text-stone-950 rounded-tr-sm' 
                            : 'bg-stone-800 text-stone-200 rounded-tl-sm border border-stone-700'
                        } ${msg.is_quick_message ? 'font-serif italic' : ''}`}
                      >
                        {msg.message_text}
                      </div>
                    </div>
                  );
                })
              )}
              <div ref={messagesEndRef} />
            </div>

            {/* Quick Messages */}
            <div className="p-2 border-t border-stone-800 bg-stone-950/50 flex gap-2 overflow-x-auto no-scrollbar">
              {PREDEFINED_QUICK_MESSAGES.map((qmsg, idx) => (
                <button
                  key={idx}
                  onClick={() => handleSendQuick(qmsg)}
                  className="whitespace-nowrap px-2.5 py-1 bg-stone-800 hover:bg-stone-700 text-amber-500 text-[10px] font-bold rounded-full transition-colors border border-stone-700 hover:border-amber-500/30"
                >
                  {qmsg}
                </button>
              ))}
            </div>

            {/* Input Area */}
            <form onSubmit={handleSend} className="p-2 bg-stone-950 border-t border-stone-800 flex gap-2">
              <input
                type="text"
                value={inputText}
                onChange={(e) => setInputText(e.target.value)}
                placeholder="Votre message..."
                className="flex-1 bg-stone-900 border border-stone-800 rounded-lg px-3 py-1.5 text-sm text-stone-200 outline-none focus:border-amber-500/50"
              />
              <button
                type="submit"
                disabled={!inputText.trim()}
                className="p-2 bg-amber-600 hover:bg-amber-500 disabled:bg-stone-800 disabled:text-stone-600 text-stone-950 rounded-lg transition-colors"
              >
                <Send size={16} />
              </button>
            </form>
          </motion.div>
        )}
      </AnimatePresence>
    </div>
  );
};
