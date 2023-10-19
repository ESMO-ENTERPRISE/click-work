import axios from "axios";

import { ApiResponse } from "../models/api.model";
import {SignIn, SignUp} from "../models/auth.model";
import { api } from "../constants/api.constant";
import {User} from "../models/user.model.ts";

export const signin = async (test: SignIn): Promise<ApiResponse<string>> => {
    return await (await axios.post<ApiResponse<string>>(`${api.url}/auth/signin`, test)).data;
};

export const signup = async (data: SignUp): Promise<ApiResponse<User>> => {
    return await (await axios.post<ApiResponse<User>>(`${api.url}/users/save`, data)).data;
};