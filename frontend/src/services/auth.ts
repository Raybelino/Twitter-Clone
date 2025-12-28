import api from "./api";

export const login = async (email: string, password: string) => {
  const res = await api.post("/auth/login", { email, password });
  localStorage.setItem("token", res.data.token);
  return res.data;
};

export const register = async (data: {
  username: string;
  email: string;
  password: string;
  firstname: string;
  lastname: string;
  country: string;
}) => {
  const res = await api.post("/auth/register", data);
  localStorage.setItem("token", res.data.token);
  return res.data;
};