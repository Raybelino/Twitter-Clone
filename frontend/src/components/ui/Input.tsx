"use client";

type Props = React.TextareaHTMLAttributes<HTMLTextAreaElement>;

export default function Input(props: Props) {
  return (
    <textarea
      {...props}
      className="w-full h-auto text-3xl p-2 my-2 outline-none field-sizing-content resize-none overflow-hidden"
    />
  );
}