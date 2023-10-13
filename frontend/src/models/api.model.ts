export type ApiResponse<T> = {
    data: T,
    status: number,
    timestamp: Date,
    message: string
}