// darkTheme.js
import { createTheme } from "@mui/material";

const darkTheme = createTheme({
    palette: {
        mode: 'dark',
        primary: {
            main: "#e91e61"
        },
        secondary: {
            main: "#5a20cb",
        },
        black: {
            main: "#242b2e"
        },
        background: {
            main: '#000000',
            default: '#0d0d0d',
            paper: '#0d0d0d'
        },
        textColor: {
            main: '#111111'
        }
    }
})

export default darkTheme;
