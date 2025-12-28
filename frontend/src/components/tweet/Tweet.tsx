import { FC } from "react";
import { Tweet as TweetType } from "@/types/tweet";
import { Heart, MessageCircle, Repeat2 } from "lucide-react";

const Tweet: FC<{ tweet: TweetType }> = ({ tweet }) => {
  return (
    <div className="border-b border-border p-4 hover:bg-gray-900">
      <div className="flex w-full items-start gap-3">
        <img
          src="/avatar.jpg"
          alt="avatar"
          className="w-10 h-10 rounded-full"
        />
        <div className="flex flex-col w-full">
          <div className="flex items-center gap-2 pb-2">
            <span className="text-2xl font-bold">{tweet.user.displayName}</span>
            <span className="text-2xl text-gray-400">@{tweet.user.username}</span>
          </div>
          <p className="text-2xl">{tweet.content}</p>
          <div className="flex justify-around -translate-x-10 gap-30 text-gray-500 text-sm mt-3">
            <span className="flex items-center gap-2"> <Heart className="w-8 h-8" /> {tweet.likes}</span>
            <span className="flex items-center gap-2"><Repeat2 className="w-8 h-8" /> {tweet.retweets}</span>
            <span className="flex items-center gap-2"><MessageCircle className="w-8 h-8" /> {tweet.comments}</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Tweet;