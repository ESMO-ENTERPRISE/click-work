import axios from "axios";
import { createMutation } from "@esmo/react-utils/fetch";

import { ApiResponse } from "../models/api.model";
import { SignIn } from "../models/auth.model";
import { api } from "../constants/api.constant";

export const useSignInMutation = createMutation<SignIn, ApiResponse<string>>(async (data) => {
    return await (await axios.post(`${api.url}/auth/signin`, data)).data;
}, {
    onSuccess(response) {
        return response.data;
    },
})