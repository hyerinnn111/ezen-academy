// props라고 인풋에 넣으면 객체 데이터를 한번에 가져옵니다

function UserList(props) {
    const users = props.users;
    return (
    <div>
        {/* users데이터에 사람이 한명이라도 있으면 map함수로 사람 이름을 한명씩 쓰게하고
        한명도 없다면 사람이 없다는 메세지 출력
        3항 연산자와 map함수의 복합 예시 */}
        {users.length > 0 ? (
            <ul>
                {users.map( (user, index) => (
                    <li key={index}>{user.name}</li>
                ))}
            </ul>
) : (
    <p>사용자가 없습니다</p>)}
</div>
    );
}

export default UserList;