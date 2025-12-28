import api from "./api";
import { Tweet } from "@/types/tweet";

export const getTweets = async (): Promise<Tweet[]> => {
  const res = await api.get("/tweets");
  return res.data;
};

export const createTweet = async (content: string): Promise<Tweet> => {
  const res = await api.post("/tweets", { content });
  return res.data;
};