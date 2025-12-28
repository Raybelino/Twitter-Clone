"use client";

import Tweet from "@/components/tweet/Tweet";
import UserCard from "@/components/User/UserCard";

export default function ProfilePage({ params }: { params: { username: string } }) {
  return (
    <div className="space-y-4">
      <UserCard username={params.username} bio="Este es mi perfil 🚀" />
      <Tweet tweet={{ id: "1", content: "Primer tweet en mi perfil", createdAt: new Date().toISOString(), retweets: 2 , user: { id: params.username, username: params.username, displayName: params.username, avatarUrl: "/default-avatar.png" }, likes: 0, comments: 0 }} />
    </div>
  );
}