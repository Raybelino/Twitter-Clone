"use client";

import { useState } from "react";
import Input from "@/components/ui/Input";
import Button from "@/components/ui/Button";
import { register } from "@/services/auth";

export default function RegisterPage() {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleRegister = async () => {
    await register({username, email, password, firstname: "Jorge", lastname: "Acosta", country: "RD"});
  };

  return (
    <div className="max-w-md mx-auto mt-20 p-6 border rounded-lg shadow">
      <h2 className="text-2xl font-bold mb-6">Registro</h2>
      <Input placeholder="Usuario" value={username} onChange={(e) => setUsername(e.target.value)} />
      <Input placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} />
      <Input placeholder="Contraseña" type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
      <Button onClick={handleRegister}>Registrarme</Button>
    </div>
  );
}
