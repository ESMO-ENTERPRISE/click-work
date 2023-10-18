import {useI18n} from "@esmo/react-utils/i18n";

export default function AppView() {
    const { t } = useI18n()

    return (
        <div className="flex flex-1 justify-content-center align-items-center">
            <div className="grid">
                <div className="col">
                    {t("appGretings")}
                </div>
            </div>
        </div>
    )
}