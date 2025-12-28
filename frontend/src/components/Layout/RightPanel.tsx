"use client";

export default function RightPanel() {
  return (
    <aside className="w-152 h-screen p-4 hidden lg:block">
      <div className="p-6 border border-border rounded-2xl">
        <h2 className="text-3xl font-bold mb-4">Trending</h2>
        <div className="w-full border-b border-border mb-4 p-2 pb-4 rounded-2xl hover:bg-neutral-900">
          <div className="flex items-center gap-1 not-only:mb-2">
          <h1 className="text-gray-500 ">Jorge</h1>
          <p className="text-gray-500">•</p>
          <span className="text-gray-500 ">@jorge</span>
          </div>
          <p className="text-2xl font-semibold">Hola, soy Jorge</p>
        </div>
        <div className="w-full border-b border-border mb-4 p-2 pb-4 rounded-2xl hover:bg-neutral-900">
          <div className="flex items-center gap-1 not-only:mb-2">
          <h1 className="text-gray-500 ">Jorge</h1>
          <p className="text-gray-500">•</p>
          <span className="text-gray-500 ">@jorge</span>
          </div>
          <p className="text-2xl font-semibold">Hola, soy Jorge</p>
        </div>
        <div className="w-full border-b border-border mb-4 p-2 pb-4 rounded-2xl hover:bg-neutral-900">
          <div className="flex items-center gap-1 not-only:mb-2">
          <h1 className="text-gray-500 ">Jorge</h1>
          <p className="text-gray-500">•</p>
          <span className="text-gray-500 ">@jorge</span>
          </div>
          <p className="text-2xl font-semibold">Hola, soy Jorge</p>
        </div>
      </div>
    </aside>
  );
}