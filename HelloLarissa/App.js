import React from 'react';
import { StyleSheet, Text, View, Dimensions, ScrollView } from 'react-native';

let largura = Dimensions.get('window').width;
let array = ['black', 'skyblue', 'steelblue'];

export default class App extends React.Component {

	preencherTela() {
		let totalArray = [];
		for(let i=1; i <= 10; i++) {
			totalArray = totalArray.concat(array);
		}
		return (
			totalArray.map((cor, index) => {
				return(
					<View style={[styles.filho, {backgroundColor: cor}]} key={index} />
				);
			})
		);
	}

	render() {
		return (
			<View style={styles.container}>
				<ScrollView>
					{this.preencherTela()}
				</ScrollView>    
			</View>
		);
	}
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		paddingTop: 100,
		backgroundColor: '#fff',
	},

	filho: {
		justifyContent: 'center',
		width: largura,
		height: 100
	}
});
