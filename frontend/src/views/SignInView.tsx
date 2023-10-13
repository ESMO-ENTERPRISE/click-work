import { InputText } from "primereact/inputtext";
import { useForm } from "@esmo/react-utils/forms";
import { useI18n } from "@esmo/react-utils/i18n";
import { SignIn } from "../models/auth.model.ts";
import { Button } from "primereact/button";
import { Password } from "primereact/password";
import { useSignInMutation } from "../services/auth.service.ts";
import { Link, useNavigation } from "@esmo/react-utils/router";
import { Loader } from "../components/Loader.component.tsx";
import { useLocalStorage } from "@esmo/react-utils/hooks";
import { auth } from "../constants/auth.constant.ts";

export default function SignInView() {
    const { t } = useI18n()
    const { errors, inputs, handleSubmit, handleChange } = useForm<SignIn>({
        defaultValues: {
            email: "",
            password: ""
        },
        validation: {
            email: {
                required: true,
                isValidEmail: (value: string) => /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/.test(value) || t("signInEmailInvalid")
            },
            password: {
                required: true
            }
        }
    })
    const { error, isWaiting, mutate } = useSignInMutation()
    const { navigate } = useNavigation()
    const [_, setToken] = useLocalStorage(auth.token_name, "")

    if (error) {
        return (
            <Loader />
        )
    }

    const submit = async (data: SignIn) => {
        const result = await mutate(data);

        if (!isWaiting) {
            setToken(result.response!.data)
            navigate("/app")
        }
    }

    return (
        <div className="flex flex-1 justify-content-center align-items-center">
            <div className="flex flex-column md:flex-row shadow-1 w-8 p-0 border-round">
                <div className="flex flex-column justify-content-center align-items-center text-center w-full md:w-8 md:px-0 px-4 py-4 lg:p-7 bg-blue-50">
                    <div className="mx-auto font-medium text-xl mb-4 text-blue-900">
                        Clickwork
                    </div>
                    <p className="m-0 text-blue-700 line-height-3">{t("singInDescription")}</p>
                </div>

                <div className="w-full p-4">
                    <div className="flex justify-content-between">
                        <span className="text-left font-bold">{t("signInTitle")}</span>
                        <Link className="text-primary cursor-pointer" to="/singup">{t("signUpTitle")}</Link>
                    </div>
                    <form className="w-full px-0 py-4 lg:p-4" onSubmit={handleSubmit(submit)}>
                        <div className="flex flex-column gap-2 text-left">
                            <label htmlFor="email">{t("signInEmail")}</label>
                            <InputText className={`${errors.email ? "p-invalid" : ""}`} id="email" name="email" value={inputs.email} onChange={handleChange} />
                            {errors.email && <small className="p-error">{errors.email}</small>}
                        </div>

                        <div className="flex flex-column gap-2 text-left mt-4">
                            <label htmlFor="password">{t("signInPassword")}</label>
                            <Password className={`${errors.password ? "p-invalid" : ""} w-full`} inputClassName="w-full" id="password" name="password" value={inputs.password} onChange={handleChange} toggleMask feedback={false} />
                            {errors.password && <small className="p-error">{errors.password}</small>}
                        </div>

                        <div className="w-full justify-content-between align-items-center mt-2 text-xs">
                            <Link className="text-primary cursor-pointer" to="/forgot-password">{t("signInForgotPassword")}</Link>
                        </div>

                        <div className="mt-6">
                            <Button className="w-full" type="submit" disabled={errors.email != "" || errors.password != "" || isWaiting} label={t("signInTitle")} />
                        </div>
                    </form>
                </div>
            </div>
        </div>

    )
}