import { ChangeEvent, useState } from 'react';
import { Box, Button } from '@mui/material';
import FormComponent from "./FormComponent";

function UserFormComponent() {
    const [formValues, setFormValues] = useState({
        name: '',
        email: '',
        message: '',
    });
    const [response, setResponse] = useState(null);
    const [isSubmitting, setIsSubmitting] = useState(false);

    const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setFormValues({
            ...formValues,
            [name]: value,
        });
    };

    const handleSubmit = async (event: any) => {
        event.preventDefault();
        setIsSubmitting(true);
        try {
            const response = await fetch(`${process.env.REACT_APP_BASE_URL}/user`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formValues),
            });

            const result = await response.json();
            setResponse(result);
        } catch (error) {
            setResponse(error as any)
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

            {response && (
                <Box sx={{ mt: 2 }}>
                    <h2>Response from API:</h2>
                    <pre>{JSON.stringify(response, null, 2)}</pre>
                </Box>
            )}
        </Box>
    );
}

export default UserFormComponent;
