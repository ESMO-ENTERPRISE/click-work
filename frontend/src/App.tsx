import {BrowserRouter, Routes, Route} from "@esmo/react-utils/router";
import {I18nProvider} from "@esmo/react-utils/i18n";
import {PrimeReactProvider} from 'primereact/api';
import "primereact/resources/themes/lara-light-indigo/theme.css";

import './App.css'
import FallbackView from "./views/FallbackView.tsx";
import en from "./i18n/en.json";
import es from "./i18n/es.json";
import SignInView from "./views/SignInView.tsx";
import SignUpView from "./views/SignUpView.tsx";
import AppView from "./views/AppView.tsx";
import {PrivateRoute} from "./routes/PrivateRoute.route.tsx";

function App() {

    // Prime config
    const primeConfig = {
        ripple: true
    }

    // I18N config
    const i18nConfig = [
        {
            language: 'en',
            resources: en
        },
        {
            language: 'es',
            resources: es
        }
    ]

    return (
        <PrimeReactProvider value={primeConfig}>
            <I18nProvider language="es" locales={i18nConfig}>
                <BrowserRouter>
                    <Routes>
                        <Route path="/app">
                            <Route path="" children={<PrivateRoute children={<AppView />} />} />
                        </Route>
                        <Route path="/signin" children={<SignInView/>} />
                        <Route path="/signup" children={<SignUpView/>} />
                        <Route path="*" children={<FallbackView/>} />
                    </Routes>
                </BrowserRouter>
            </I18nProvider>
        </PrimeReactProvider>
    )
}

export default App
