import axios from "axios";
import { createMutation } from "@esmo/react-utils/fetch";

import { ApiResponse } from "../models/api.model";
import {SignIn, SignUp} from "../models/auth.model";
import { api } from "../constants/api.constant";
import {User} from "../models/user.model.ts";

export const useSignInMutation = createMutation<SignIn, ApiResponse<string>>(async (data) => {
    return await (await axios.post(`${api.url}/auth/signin`, data)).data;
}, {
    onSuccess(response) {
        console.log(`Access token: ${response.data}`);
        return response.data;
    },
})

export const useSignUpMutation = createMutation<SignUp, ApiResponse<User>>(async (data) => {
    return await (await axios.post(`${api.url}/users/save`, data)).data;
}, {
    onSuccess(response) {
        return response.data;
    },
})