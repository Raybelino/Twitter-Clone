"use client";

import Tweet from "@/components/tweet/Tweet";
import TweetForm from "@/components/tweet/TweetForm";
// 👈 unifica la ruta en minúsculas para evitar el error de casing
import { Tweet as TweetType } from "@/types/tweet";

export default function HomePage() {
  const tweets: TweetType[] = [
    {
      id: "1",
      content: "Hola, soy Jorge 👋",
      likes: 5,
      comments: 2,
      retweets: 1,
      createdAt: new Date().toISOString(),
      user: {
        id: "u1",
        username: "jorge",
        displayName: "Jorge Rayber",
        avatarUrl: "/default-avatar.png",
      },
    },
    {
      id: "2",
      content: "Next.js + Tailwind = 🔥",
      likes: 10,
      comments: 3,
      retweets: 1,
      createdAt: new Date().toISOString(),
      user: {
        id: "u2",
        username: "rayber",
        displayName: "Rayber Dev",
        avatarUrl: "/default-avatar.png",
      },
    },
  ];

  return (
    <div className="space-y-4">
      <TweetForm />
      {tweets.map((tweet) => (
        <Tweet key={tweet.id} tweet={tweet} />
      ))}
    </div>
  );
}