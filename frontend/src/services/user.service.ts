import {createQuery} from "@esmo/react-utils/fetch";
import {User} from "../models/user.model.ts";
import {ApiResponse} from "../models/api.model.ts";
import axios from "axios";
import {api} from "../constants/api.constant.ts";

export const useGetMeQuery = createQuery<{token: string}, ApiResponse<User>>(async (token) => {
    const result = await axios.get(`${api.url}`, {
        headers: {
            Authorization: `Bearer ${token}`
        }
    });

    return await result.data;
});