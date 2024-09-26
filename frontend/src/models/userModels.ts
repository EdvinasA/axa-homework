export type UserForm = {
    name: string;
    email: string;
    message: string;
}

export type UserCreationResponse = {
    name: string;
    email: string;
    message: string;
}

export type CustomError = {
    message: string;
}