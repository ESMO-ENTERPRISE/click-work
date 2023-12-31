export type User = {
    id: number
    name: string
    lastName: string
    email: string
    password: string
    username: string
    role: "USER" | "ADMIN"
}