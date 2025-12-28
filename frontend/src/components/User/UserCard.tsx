"use client";

type Props = {
  username: string;
  bio: string;
};

export default function UserCard({ username, bio }: Props) {
  return (
    <div className="border-b border-gray-200 p-4">
      <h2 className="font-bold text-xl">@{username}</h2>
      <p className="text-gray-600">{bio}</p>
    </div>
  );
}