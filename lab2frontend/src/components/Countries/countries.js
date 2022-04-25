import React from "react";

const countries=(props)=>{
    return(
        <div className={"container"}>
            <hr/>
            <h1 className={"text-left"}>Countries</h1>
            <hr/>
            <div>
                <table className={"table"}>
                    <thead>
                    <tr>
                        <th scope={"col"}>Name</th>
                        <th scope={"col"}>Continent</th>
                    </tr>
                    </thead>
                    <tbody>
                    {props.countries.map((term)=>{
                        return(
                            <tr key={term.id}>
                                <td>{term.name}</td>
                                <td>{term.continent}</td>
                            </tr>
                        );
                    })}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
export default countries;