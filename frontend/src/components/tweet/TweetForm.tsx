"use client";

import { useState } from "react";
import Button from "@/components/ui/Button";
import Input from "@/components/ui/Input";

export default function TweetForm() {
  const [content, setContent] = useState("");

  const handleTweet = () => {
    console.log("Nuevo tweet:", content);
    setContent("");
  };

  return (
    <div className="border-b border-border p-4">
      <div className="flex items-start gap-3 mb-4">
        <img src="/avatar.jpg" alt="Avatar" className="rounded-full" />
        <Input
          placeholder="¿Qué está pasando?"
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />
      </div>
      <div className="flex justify-end">
        <Button onClick={handleTweet}>Tweet</Button>
      </div>
    </div>
  );
}