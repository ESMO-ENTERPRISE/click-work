import { Route } from '@esmo/react-utils'
import SignInView from "./views/SignInView.tsx";

export const routes: Route[] = [
    {
        path: '/signin',
        component: SignInView
    }
]