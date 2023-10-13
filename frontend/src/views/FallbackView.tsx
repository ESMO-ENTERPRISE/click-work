import {useI18n} from "@esmo/react-utils/i18n";
import {Link} from "@esmo/react-utils/router";

export default function FallbackView() {
    const { t } = useI18n()

    return (
        <div className="flex flex-1 justify-content-center align-items-center">
            <h1 className="font-bold text-7xl text-primary">404</h1>
            <div className="ml-2">
                <h1 className="font-bold text-4xl text-color-secondary mb-0">{t("notFound")}</h1>
                <Link className="text-color-secondary underline cursor-pointer" to="/app">{t("goBack")}</Link>
            </div>
        </div>
    )
}