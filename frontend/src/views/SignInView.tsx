import {Card} from "primereact/card";
import {InputText} from "primereact/inputtext";
import {email, required, useEsmoI18n, useForm} from "@esmo/react-utils";
import {SignIn} from "../models/auth.model.ts";
import {Button} from "primereact/button";
import {Password} from "primereact/password";

export default function SignInView() {
    const {t} = useEsmoI18n()
    const {ref, data, errors, handleSubmit, valid} = useForm<SignIn>(
        {
            email: ["", [required(t("signInEmailRequired")), email(t("signInEmailInvalid"))]],
            password: ["", [required(t("signInPasswordRequired"))]]
        }, {
            validateOn: "change"
        })

    const submit = () => {
        console.log('data', data)
    }

    return (
        <div className="flex flex-1 justify-content-center align-items-center">
            <Card title={t("signInTitle")} className="shadow-1 text-center">
                <form ref={ref} onSubmit={handleSubmit(submit)}>
                    <div className="flex flex-column gap-2 text-left">
                        <label htmlFor="email">{t("signInEmail")}</label>
                        <InputText id="email" name="email" className={`${errors.email ? "p-invalid" : ""}`} />
                        {errors.email && <small className="p-error">{errors.email}</small>}
                    </div>

                    <div className="flex flex-column gap-2 text-left mt-4">
                        <label htmlFor="password">{t("signInPassword")}</label>
                        <Password id="password" name="password" className={`${errors.password ? "p-invalid" : ""}`} toggleMask feedback={false} />
                        {errors.password && <small className="p-error">{errors.password}</small>}
                    </div>

                    <div className="mt-4">
                        <Button type="submit" disabled={!valid} label={t("signInTitle")} />
                    </div>
                </form>
            </Card>
        </div>

    )
}