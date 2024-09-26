import React from 'react';
import { Box, Typography } from '@mui/material';

type DisplayDataComponentProps = {
    title: string;
    value: string;
};

function DisplayDataComponent({ title, value }: DisplayDataComponentProps) {
    return (
        <Box sx={{ mb: 2 }}>
            <Typography variant="h6" component="div">
                {title}
            </Typography>
            <Typography variant="body1" color="textSecondary">
                {value}
            </Typography>
        </Box>
    );
}

export default DisplayDataComponent;
