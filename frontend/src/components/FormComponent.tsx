import React, {ChangeEvent} from 'react';
import { FormControl, InputLabel, Input, FormHelperText } from '@mui/material';

interface FormComponentProps {
    value: string;
    name: string;
    label: string;
    onChange: (event: ChangeEvent<HTMLInputElement>) => void;
    required?: boolean;
    helperText: string;
    rows?: number;
    multiline?: boolean;
    type?: string;
}

function FormComponent({
                          value,
                          name,
                          label,
                          onChange,
                          required = true,
                          helperText,
                          multiline = false,
                          type = '',
                          rows = 4,
                      }: FormComponentProps) {
    return (
        <FormControl fullWidth sx={{ mb: 2 }}>
            <InputLabel htmlFor={name}>{label}</InputLabel>
            <Input
                name={name}
                type={type}
                value={value}
                onChange={onChange}
                required={required}
                multiline={multiline}
                rows={rows}
            />
            <FormHelperText>{helperText}</FormHelperText>
        </FormControl>
    );
}

export default FormComponent;