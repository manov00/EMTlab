import React from 'react';

const categories = (props) => {
    return (
        <div className={"container"}>
            <hr/>
            <h1 className={"text-left"}>Categories</h1>
            <hr/>
            <div>
                <table className={"table"}>
                    <thead>
                    <tr>
                        <th scope={"col"}>Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    {props.categories.map((term) => {
                        return (
                            <tr key={term}>
                                <td>{term}</td>
                            </tr>
                        );
                    })}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
export default categories;