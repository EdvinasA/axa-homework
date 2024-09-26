import React from 'react';
import { Box } from '@mui/material';
import './App.css';
import UserFormComponent from "./components/UserFormComponent";

function App() {
    return (
        <Box sx={{ p: 2 }}>
            <UserFormComponent/>
        </Box>
    );
}

export default App;
