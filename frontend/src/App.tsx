import {createRouter, RouteSettings} from "@esmo/react-utils/router";
import {I18nProvider} from "@esmo/react-utils/i18n";
import {PrimeReactProvider} from 'primereact/api';
import "primereact/resources/themes/lara-light-indigo/theme.css";
import './App.css'
import {routes} from "./routes.ts";
import FallbackView from "./views/FallbackView.tsx";
import en from "./i18n/en.json";
import es from "./i18n/es.json";

function App() {

    // Prime config
    const primeConfig = {
        ripple: true
    }

    // Router config
    const routerConfig: RouteSettings = {
        fallback: FallbackView,
        routes: routes
    }
    const [Router, RouterView] = createRouter(routerConfig);

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
                <Router>
                    <RouterView/>
                </Router>
            </I18nProvider>
        </PrimeReactProvider>
    )
}

export default App
