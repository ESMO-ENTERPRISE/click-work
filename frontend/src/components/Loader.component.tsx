import { ProgressSpinner } from "primereact/progressspinner";

export function Loader() {
    return (
        <div className="flex flex-1 align-items-center align-items-center">
            <ProgressSpinner style={{width: '50px', height: '50px'}} strokeWidth="8" fill="var(--surface-ground)" animationDuration=".5s" />
        </div>
    )
}