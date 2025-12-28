"use client";

import Link from "next/link";
import { Home, User, LogOut } from "lucide-react";

export default function Sidebar() {

  return (
    <aside className="w-115 h-screen border-r items-center pt-10 border-border flex flex-col">
      <div>
        <h1 className="text-3xl font-black text-blue-500 mb-8">Twitter Clone</h1>

        <nav className="flex flex-col gap-4">
          <Link href="/" className="flex items-center gap-5 w-fit p-4 text-3xl font-bold hover:bg-bg-light rounded-full">
            <Home /> Home
          </Link>
          <Link href="/profile/jorgito" className="flex items-center gap-5 w-fit p-4 text-3xl font-bold hover:bg-bg-light rounded-full">
            <User /> Profile
          </Link>
          <button className="flex items-center gap-5 w-fit p-4 text-3xl font-bold hover:bg-bg-light rounded-full">
            <LogOut /> Logout
          </button>
        </nav>
      </div>
    </aside>
  );
}