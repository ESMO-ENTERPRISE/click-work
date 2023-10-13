import {Route} from '@esmo/react-utils/router';
import SignInView from "./views/SignInView.tsx";
import SignUpView from "./views/SignUpView.tsx";

export const routes: Route[] = [
    {
        path: '/signin',
        component: SignInView
    },
    {
        path: '/signup',
        component: SignUpView
    }
]