"use client";

type Props = React.ButtonHTMLAttributes<HTMLButtonElement>;

export default function Button({ children, ...props }: Props) {
  return (
    <button
      {...props}
      className="flex items-center gap-2 text-2xl font-bold p-2 px-4 text-black bg-white hover:bg-bg-lighter rounded-full cursor-pointer"
    >
      {children}
    </button>
  );
}