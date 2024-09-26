import { ChangeEvent, useState } from 'react';
import { Box, Button } from '@mui/material';
import FormComponent from "./FormComponent";
import { fetchRequest } from "../api/api";
import { UserCreationResponse, UserForm } from "../models/userModels";
import DisplayDataComponent from "./DisplayDataComponent";

function UserFormComponent() {
    const [formValues, setFormValues] = useState<UserForm>({
        name: '',
        email: '',
        message: '',
    });
    const [response, setResponse] = useState<UserCreationResponse | null>(null);
    const [error, setError] = useState<string | null>(null);
    const [isSubmitting, setIsSubmitting] = useState<boolean>(false);

    const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setFormValues({
            ...formValues,
            [name]: value,
        });
    };

    const handleSubmit = async (event: any) => {
        setResponse(null)
        setError(null)
        event.preventDefault();
        setIsSubmitting(true);
        try {
            const result = await fetchRequest<UserCreationResponse>(
                `${process.env.REACT_APP_BASE_URL}/user`,
                'POST',
                formValues
            );
            setResponse(result);
        } catch (error) {
            setError((error as Error).message);
        } finally {
            setIsSubmitting(false);
        }
    };

    return (
        <Box>
            <h1>User Form</h1>
            <form onSubmit={handleSubmit}>
                <FormComponent
                    name={'name'}
                    label={'Name'}
                    value={formValues.name}
                    onChange={handleInputChange}
                    helperText={'Enter your full name'}
                />

                <FormComponent
                    name={'email'}
                    label={'Email'}
                    type={'email'}
                    value={formValues.email}
                    onChange={handleInputChange}
                    helperText={'Enter your email address'}
                 />

                <FormComponent
                    label={'Message'}
                    name={'message'}
                    value={formValues.message}
                    onChange={handleInputChange}
                    helperText={'Enter your message'}
                    multiline
                    rows={4}
                 />

                <Button
                    type="submit"
                    variant="contained"
                    color="primary"
                    disabled={isSubmitting}
                >
                    {isSubmitting ? 'Submitting...' : 'Submit'}
                </Button>
            </form>

            {error ? (
                <Box sx={{ mt: 2, color: 'red' }}>
                    <DisplayDataComponent title="Error" value={error} />
                </Box>
            ) : response ? (
                <Box sx={{ mt: 2 }}>
                    <h2>New user created</h2>
                    <DisplayDataComponent title="Name" value={response.name} />
                    <DisplayDataComponent title="Email" value={response.email} />
                    <DisplayDataComponent title="Message" value={response.message} />
                </Box>
            ) : null}
        </Box>
    );
}

export default UserFormComponent;
