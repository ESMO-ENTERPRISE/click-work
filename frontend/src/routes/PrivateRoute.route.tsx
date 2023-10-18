import React, {ReactNode} from "react";
import {useLocalStorage} from "@esmo/react-utils/hooks";
import {Redirect} from "@esmo/react-utils/router";

import {auth} from "../constants/auth.constant.ts";

type Props = {
    children: React.ReactNode
}

export function PrivateRoute({children}: Props): ReactNode {
    const [token] = useLocalStorage(auth.token_name, "")

    if (!token) {
        return <Redirect href="/signin" />
    }

    return children;
}