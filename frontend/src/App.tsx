import React, { ChangeEvent, useState } from 'react';
import {Box, Button, FormControl, FormHelperText, Input, InputLabel, TextField } from '@mui/material';
import './App.css';

function App() {
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
            const response = await fetch('http://localhost:8080/sanitize', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formValues),
            });

            const result = await response.json();
            setResponse(result);
        } catch (error) {
            console.error('Error:', error);
        } finally {
            setIsSubmitting(false);
        }
    };

    return (
        <Box sx={{ p: 2 }}>
            <h1>Simple Form</h1>
            <form onSubmit={handleSubmit}>
                <FormControl fullWidth sx={{ mb: 2 }}>
                    <InputLabel htmlFor="name">Name</InputLabel>
                    <Input
                        id="name"
                        name="name"
                        value={formValues.name}
                        onChange={handleInputChange}
                        required
                    />
                    <FormHelperText>Enter your full name</FormHelperText>
                </FormControl>

                <FormControl fullWidth sx={{ mb: 2 }}>
                    <InputLabel htmlFor="email">Email</InputLabel>
                    <Input
                        id="email"
                        name="email"
                        type="email"
                        value={formValues.email}
                        onChange={handleInputChange}
                        required
                    />
                    <FormHelperText>Enter your email address</FormHelperText>
                </FormControl>

                <FormControl fullWidth sx={{ mb: 2 }}>
                    <InputLabel htmlFor="message">Message</InputLabel>
                    <Input
                        id="message"
                        name="message"
                        value={formValues.message}
                        onChange={handleInputChange}
                        required
                        multiline
                        rows={4}
                    />
                    <FormHelperText>Enter your message</FormHelperText>
                </FormControl>

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
};

export default App;
