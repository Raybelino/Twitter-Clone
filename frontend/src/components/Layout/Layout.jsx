"use client";

import Sidebar from "@/components/Layout/Sidebar";
import Navbar from "@/components/Layout/Navbar";
import RightPanel from "@/components/Layout/RightPanel";

export default function Layout({ children }) {
  return (
    <div className="flex min-h-screen">
      {/* Sidebar */}
      <Sidebar />

      {/* Feed */}
      <main className="flex-1 max-w-4xl border-r border-border">
        <Navbar />
        <div className="p-4">{children}</div>
      </main>

      {/* Right Panel */}
      <RightPanel />
    </div>
  );
}