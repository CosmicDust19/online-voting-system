import React from "react";

export default function FancyText({color = "yellow", content, ...props}) {

    return (
        <span className={`fill-color fill-color-${color}`} fill-text-content={content} {...props}>
            {content}
        </span>
    )

}